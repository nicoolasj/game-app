package com.example.gameapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.example.gameapp.R
import com.example.gameapp.presentation.di.Injector
import javax.inject.Inject

private const val TAG = "GameActivity"

class GameActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: GameViewModelFactory
    private lateinit var gameViewModel: GameViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        (application as Injector).createGameSubComponent().inject(this)
        gameViewModel = ViewModelProvider(this, factory).get(GameViewModel::class.java)
        gameViewModel.getGames().observe(this, {
            Log.d(TAG, "$it")
        })
    }
}