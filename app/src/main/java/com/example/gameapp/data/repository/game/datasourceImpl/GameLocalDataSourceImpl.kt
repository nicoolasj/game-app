package com.example.gameapp.data.repository.game.datasourceImpl

import com.example.gameapp.data.db.GameDao
import com.example.gameapp.data.model.game.Game
import com.example.gameapp.data.repository.game.datasource.GameLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GameLocalDataSourceImpl(private val gameDao: GameDao) : GameLocalDataSource {
    override suspend fun getGamesFromDatabase(): List<Game> = gameDao.getGames()

    override suspend fun insertGameToDatabase(game: List<Game>) {
        CoroutineScope(Dispatchers.IO).launch { gameDao.insertGames(game) }
    }

    override suspend fun deleteAllGamesFromDatabase() {
        CoroutineScope(Dispatchers.IO).launch {
            gameDao.deleAllGames()
        }
    }
}