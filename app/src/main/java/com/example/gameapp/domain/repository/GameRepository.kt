package com.example.gameapp.domain.repository

import com.example.gameapp.data.model.game.Game

interface GameRepository {
    suspend fun getGames(): List<Game>
    suspend fun updateGames(): List<Game>
}
