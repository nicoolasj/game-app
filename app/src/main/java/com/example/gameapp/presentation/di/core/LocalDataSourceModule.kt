package com.example.gameapp.presentation.di.core

import com.example.gameapp.data.db.GameDao
import com.example.gameapp.data.repository.game.datasource.GameLocalDataSource
import com.example.gameapp.data.repository.game.datasourceImpl.GameLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataSourceModule {

    @Singleton
    @Provides
    fun provideGameLocalDataSource(gameDao: GameDao): GameLocalDataSource {
        return GameLocalDataSourceImpl(gameDao)
    }
}
