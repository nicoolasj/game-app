package com.example.gameapp.presentation.di.core

import com.example.gameapp.data.repository.game.datasource.GameCacheDataSource
import com.example.gameapp.data.repository.game.datasourceImpl.GameCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataSouceModule {

    @Singleton
    @Provides
    fun provideGameCacheDataSource(): GameCacheDataSource {
        return GameCacheDataSourceImpl()
    }
}
