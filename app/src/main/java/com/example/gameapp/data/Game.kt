package com.example.gameapp.data


import com.google.gson.annotations.SerializedName

data class Game(
    @SerializedName("background_image")
    val backgroundImage: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("metacritic")
    val metacritic: Int,
    @SerializedName("name")
    val name: String
)