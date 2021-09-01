package com.example.gameapp.presentation.di.game

import com.example.gameapp.presentation.GameActivity
import dagger.Subcomponent

@GameScope
@Subcomponent(modules = [GameModule::class])
interface GameSubComponent {
    fun inject(gameActivity: GameActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create(): GameSubComponent
    }
}