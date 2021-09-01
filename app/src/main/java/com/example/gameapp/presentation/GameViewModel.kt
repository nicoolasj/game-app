package com.example.gameapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.example.gameapp.domain.usecase.GetGamesUseCase
import com.example.gameapp.domain.usecase.UpdateGamesUseCase
import kotlinx.coroutines.launch

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