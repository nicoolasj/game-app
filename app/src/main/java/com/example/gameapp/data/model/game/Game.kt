package com.example.gameapp.data.model.game

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "game_table")
data class Game(
    @SerializedName("background_image")
    val backgroundImage: String,
    @PrimaryKey
    @SerializedName("id")
    val id: Int,
    @SerializedName("metacritic")
    val metacritic: Int,
    @SerializedName("name")
    val name: String
)
