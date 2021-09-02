package com.example.gameapp.presentation.di.core

import com.example.gameapp.presentation.di.game.GameSubComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        NetModule::class,
        DataBaseModule::class,
        RemoteDataSourceModule::class,
        LocalDataSourceModule::class,
        CacheDataSouceModule::class,
        RepositoryModule::class,
        UseCaseModule::class,
        AppModule::class
    ]
)
interface AppComponent {

    fun gameSubComponent(): GameSubComponent.Factory
}
