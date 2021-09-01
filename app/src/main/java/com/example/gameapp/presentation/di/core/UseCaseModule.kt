package com.example.gameapp.presentation.di.core

import com.example.gameapp.domain.repository.GameRepository
import com.example.gameapp.domain.usecase.GetGamesUseCase
import com.example.gameapp.domain.usecase.UpdateGamesUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UseCaseModule {

    @Provides
    fun provideGetGameUseCase(gameRepository: GameRepository): GetGamesUseCase {
        return GetGamesUseCase(gameRepository)
    }

    @Provides
    fun provideUpdateGameUseCase(gameRepository: GameRepository): UpdateGamesUseCase {
        return UpdateGamesUseCase(gameRepository)
    }
}