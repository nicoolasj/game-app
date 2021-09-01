package com.example.gameapp.domain

import com.example.gameapp.data.model.game.Game

class GetGamesUseCase(private val gameRepository: GameRepository) {
    suspend fun execute(): List<Game> = gameRepository.getGames()
}