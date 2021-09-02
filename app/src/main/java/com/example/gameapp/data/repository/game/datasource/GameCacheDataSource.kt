package com.example.gameapp.data.repository.game.datasource

import com.example.gameapp.data.model.game.Game

interface GameCacheDataSource {
    suspend fun getGamesFromCache(): List<Game>
    suspend fun saveGamesToCache(game: List<Game>)
}
