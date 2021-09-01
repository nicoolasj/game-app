package com.example.gameapp.data


import com.google.gson.annotations.SerializedName

data class GameList(
    @SerializedName("results")
    val games: List<Game>
)