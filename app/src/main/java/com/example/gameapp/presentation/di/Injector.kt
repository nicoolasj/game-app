package com.example.gameapp.presentation.di

import com.example.gameapp.presentation.di.game.GameSubComponent

interface Injector {
    fun createGameSubComponent(): GameSubComponent
}
