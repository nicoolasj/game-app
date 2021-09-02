package com.example.gameapp.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.gameapp.R
import com.example.gameapp.data.model.game.Game

class GameAdapter : RecyclerView.Adapter<GameAdapter.ViewHolder>() {

    private var gameList = ArrayList<Game>()

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val titleTextView: TextView = view.findViewById(R.id.titleTextView)
        val imageView: ImageView = view.findViewById(R.id.imageView)
        val metacriticTextView: TextView = view.findViewById(R.id.metacriticTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.game_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            titleTextView.text = gameList[position].name
            metacriticTextView.text = "Metacritic: ${gameList[position].metacritic}"
            Glide.with(imageView)
                .load(gameList[position].backgroundImage)
                .into(imageView)
        }
    }

    override fun getItemCount(): Int = gameList.size

    fun setGameList(game: List<Game>) {
        gameList.clear()
        gameList.addAll(game)
        notifyDataSetChanged()
    }
}
