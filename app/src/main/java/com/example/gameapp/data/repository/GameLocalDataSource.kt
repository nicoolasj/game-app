package com.example.gameapp.data.repository

import com.example.gameapp.data.model.game.Game

interface GameLocalDataSource {
    suspend fun getGamesFromDatabase(): List<Game>
    suspend fun insertGameToDatabase(game: List<Game>)
    suspend fun deleteAllGamesFromDatabase()
}