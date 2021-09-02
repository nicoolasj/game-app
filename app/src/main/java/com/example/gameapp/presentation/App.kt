package com.example.gameapp.presentation

import android.app.Application
import com.example.gameapp.BuildConfig
import com.example.gameapp.presentation.di.Injector
import com.example.gameapp.presentation.di.core.AppComponent
import com.example.gameapp.presentation.di.core.AppModule
import com.example.gameapp.presentation.di.core.DaggerAppComponent
import com.example.gameapp.presentation.di.core.NetModule
import com.example.gameapp.presentation.di.core.RemoteDataSourceModule
import com.example.gameapp.presentation.di.game.GameSubComponent

class App : Application(), Injector {

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule("https://api.rawg.io/api/"))
            .remoteDataSourceModule(RemoteDataSourceModule(BuildConfig.KEY))
            .build()
    }

    override fun createGameSubComponent(): GameSubComponent {
        return appComponent.gameSubComponent().create()
    }
}
