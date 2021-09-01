package com.example.gameapp.presentation.di

import com.example.gameapp.domain.repository.GameRepository
import com.example.gameapp.domain.usecase.GetGamesUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class GetUseCaseModule {

    @Singleton
    @Provides
    fun provideGetGameUseCase(gameRepository: GameRepository): GetGamesUseCase {
        return GetGamesUseCase(gameRepository)
    }
}