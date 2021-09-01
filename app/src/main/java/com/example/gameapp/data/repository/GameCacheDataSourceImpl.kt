package com.example.gameapp.data.repository

import com.example.gameapp.data.model.game.Game
import com.example.gameapp.data.repository.datasource.GameCacheDataSource

class GameCacheDataSourceImpl : GameCacheDataSource {

    private var gameList = ArrayList<Game>()

    override suspend fun getGamesFromCache(): List<Game> = gameList

    override suspend fun saveGamesToCache(game: List<Game>) {
        gameList.clear()
        gameList = ArrayList(game)
    }
}