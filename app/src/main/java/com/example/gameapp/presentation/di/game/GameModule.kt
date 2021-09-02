package com.example.gameapp.presentation.di.game

import com.example.gameapp.domain.usecase.GetGamesUseCase
import com.example.gameapp.domain.usecase.UpdateGamesUseCase
import com.example.gameapp.presentation.viewmodel.GameViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class GameModule {

    @GameScope
    @Provides
    fun provideGameViewModelFactory(
        getGamesUseCase: GetGamesUseCase,
        updateGamesUseCase: UpdateGamesUseCase
    ): GameViewModelFactory {
        return GameViewModelFactory(getGamesUseCase, updateGamesUseCase)
    }
}
