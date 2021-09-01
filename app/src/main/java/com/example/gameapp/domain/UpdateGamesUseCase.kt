package com.example.gameapp.domain

import com.example.gameapp.data.model.game.Game

class UpdateGamesUseCase(private val gameRepository: GameRepository) {
    suspend fun execute(): List<Game> = gameRepository.updateGames()
}