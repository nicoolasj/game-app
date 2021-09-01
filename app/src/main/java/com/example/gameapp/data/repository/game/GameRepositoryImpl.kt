package com.example.gameapp.data.repository.game

import android.util.Log
import com.example.gameapp.data.model.game.Game
import com.example.gameapp.data.repository.game.datasource.GameCacheDataSource
import com.example.gameapp.data.repository.game.datasource.GameLocalDataSource
import com.example.gameapp.data.repository.game.datasource.GameRemoteDataSource
import com.example.gameapp.domain.repository.GameRepository
import java.lang.Exception

class GameRepositoryImpl(
    private val gameRemoteDataSource: GameRemoteDataSource,
    private val gameLocalDataSource: GameLocalDataSource,
    private val gameCacheDataSource: GameCacheDataSource
) : GameRepository {
    override suspend fun getGames(): List<Game> {
        return getGamesFromCache()
    }

    override suspend fun updateGames(): List<Game> {
        val newGameList = getGamesFromApi()
        gameLocalDataSource.deleteAllGamesFromDatabase()
        gameLocalDataSource.insertGameToDatabase(newGameList)
        gameCacheDataSource.saveGamesToCache(newGameList)
        return newGameList
    }

    suspend fun getGamesFromApi(): List<Game> {
        lateinit var gameList: List<Game>

        try {
            val response = gameRemoteDataSource.getGames()
            val body = response.body()!!
            gameList = body.games
        } catch (e: Exception) {
            Log.e("GameAppException", "${e.message}")
        }

        return gameList
    }

    suspend fun getGamesFromDatabase(): List<Game> {
        lateinit var gameList: List<Game>

        try {
            gameList = gameLocalDataSource.getGamesFromDatabase()
        } catch (e: Exception) {
            Log.e("GameAppException", "${e.message}")
        }
        if (gameList.isNotEmpty()) {
            return gameList
        } else {
            gameList = getGamesFromApi()
            gameLocalDataSource.insertGameToDatabase(gameList)
        }
        return gameList
    }

    suspend fun getGamesFromCache(): List<Game> {
        lateinit var gameList: List<Game>

        try {
            gameList = gameCacheDataSource.getGamesFromCache()
        } catch (e: Exception) {
            Log.e("GameAppException", "${e.message}")
        }
        if (gameList.isNotEmpty()) {
            return gameList
        } else {
            gameList = getGamesFromDatabase()
            gameCacheDataSource.saveGamesToCache(gameList)
        }
        return gameList
    }
}