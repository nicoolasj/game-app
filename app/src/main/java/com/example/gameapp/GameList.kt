package com.example.gameapp


import com.google.gson.annotations.SerializedName

data class GameList(
    @SerializedName("results")
    val games: List<Game>
)