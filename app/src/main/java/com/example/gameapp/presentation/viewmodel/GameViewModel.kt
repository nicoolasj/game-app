package com.example.gameapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.gameapp.domain.usecase.GetGamesUseCase
import com.example.gameapp.domain.usecase.UpdateGamesUseCase

class GameViewModel(
    private val getGamesUseCase: GetGamesUseCase,
    private val updateGamesUseCase: UpdateGamesUseCase
) : ViewModel() {

    fun getGames() = liveData {
        val gameList = getGamesUseCase.execute()
        emit(gameList)
    }

    fun updateGames() = liveData {
        val gameList = updateGamesUseCase.execute()
        emit(gameList)
    }
}
