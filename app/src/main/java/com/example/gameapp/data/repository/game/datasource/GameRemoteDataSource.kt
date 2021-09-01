package com.example.gameapp.data.repository.game.datasource

import com.example.gameapp.data.model.game.GameList
import retrofit2.Response

interface GameRemoteDataSource {
    suspend fun getGames(): Response<GameList>
}