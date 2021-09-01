package com.example.gameapp.data.repository.game.datasourceImpl

import com.example.gameapp.data.api.RawgService
import com.example.gameapp.data.model.game.GameList
import com.example.gameapp.data.repository.game.datasource.GameRemoteDataSource
import retrofit2.Response

class GameRemoteDataSourceImpl(private val rawgService: RawgService, private val key: String) :
    GameRemoteDataSource {
    override suspend fun getGames(): Response<GameList> = rawgService.getGames(key)
}