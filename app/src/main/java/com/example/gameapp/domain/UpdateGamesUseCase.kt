package com.example.gameapp.domain

import com.example.gameapp.data.model.game.Game
import com.example.gameapp.domain.repository.GameRepository

class UpdateGamesUseCase(private val gameRepository: GameRepository) {
    suspend fun execute(): List<Game> = gameRepository.updateGames()
}