package com.example.gameapp.presentation.di.core

import com.example.gameapp.data.repository.game.GameRepositoryImpl
import com.example.gameapp.data.repository.game.datasource.GameCacheDataSource
import com.example.gameapp.data.repository.game.datasource.GameLocalDataSource
import com.example.gameapp.data.repository.game.datasource.GameRemoteDataSource
import com.example.gameapp.domain.repository.GameRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideGameRepository(
        gameRemoteDataSource: GameRemoteDataSource,
        gameLocalDataSource: GameLocalDataSource,
        gameCacheDataSource: GameCacheDataSource
    ): GameRepository {
        return GameRepositoryImpl(gameRemoteDataSource, gameLocalDataSource, gameCacheDataSource)
    }
}
