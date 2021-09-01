package com.example.gameapp.data.api

import com.example.gameapp.data.model.game.GameList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RawgService {

    @GET("games")
    suspend fun getGames(@Query("key") key: String): Response<GameList>
}