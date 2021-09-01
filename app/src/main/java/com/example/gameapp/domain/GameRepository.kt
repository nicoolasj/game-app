package com.example.gameapp.domain

import com.example.gameapp.data.model.game.Game
import com.example.gameapp.data.model.game.GameList
import retrofit2.Response

interface GameRepository {
    suspend fun getGames(): List<Game>
    suspend fun updateGames(): List<Game>
}