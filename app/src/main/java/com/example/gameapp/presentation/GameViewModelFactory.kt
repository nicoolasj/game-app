package com.example.gameapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.gameapp.domain.usecase.GetGamesUseCase
import com.example.gameapp.domain.usecase.UpdateGamesUseCase
import java.lang.IllegalArgumentException

class GameViewModelFactory(
    private val getGamesUseCase: GetGamesUseCase,
    private val updateGamesUseCase: UpdateGamesUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(GameViewModel::class.java))
            return GameViewModel(getGamesUseCase, updateGamesUseCase) as T
        throw IllegalArgumentException("ViewModel class not found")
    }
}