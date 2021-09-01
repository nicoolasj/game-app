package com.example.gameapp.data.model.game


import com.google.gson.annotations.SerializedName

data class GameList(
    @SerializedName("results")
    val games: List<Game>
)