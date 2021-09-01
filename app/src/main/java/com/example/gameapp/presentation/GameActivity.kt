package com.example.gameapp.presentation

import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gameapp.R
import com.example.gameapp.databinding.ActivityGameBinding
import com.example.gameapp.presentation.di.Injector
import javax.inject.Inject

private const val TAG = "GameActivity"

class GameActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: GameViewModelFactory
    private lateinit var gameViewModel: GameViewModel
    private lateinit var binding: ActivityGameBinding
    private lateinit var adapter: GameAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_game)
        (application as Injector).createGameSubComponent().inject(this)
        gameViewModel = ViewModelProvider(this, factory).get(GameViewModel::class.java)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        adapter = GameAdapter()
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        displayGameList()
    }

    private fun displayGameList() {
        binding.progressBar.visibility = View.VISIBLE
        gameViewModel.getGames().observe(this, {
            adapter.setGameList(it)
            Log.d(TAG, "$it")
            binding.progressBar.visibility = View.INVISIBLE
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.update, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.update) updateGames()
        return super.onOptionsItemSelected(item)
    }

    fun updateGames() {
        binding.progressBar.visibility = View.VISIBLE
        val response = gameViewModel.updateGames()
        response.observe(this, {
            adapter.setGameList(it)
            binding.progressBar.visibility = View.INVISIBLE
        })
    }
}