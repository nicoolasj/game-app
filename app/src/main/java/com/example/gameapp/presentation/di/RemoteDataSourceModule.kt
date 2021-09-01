package com.example.gameapp.presentation.di

import com.example.gameapp.data.api.RawgService
import com.example.gameapp.data.repository.game.datasource.GameRemoteDataSource
import com.example.gameapp.data.repository.game.datasourceImpl.GameRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataSourceModule(private val key: String) {

    @Singleton
    @Provides
    fun provideGameRemoteDataSource(rawgService: RawgService): GameRemoteDataSource {
        return GameRemoteDataSourceImpl(rawgService, key)
    }
}