package com.example.gameapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.gameapp.GameDao
import com.example.gameapp.data.model.game.Game

@Database(entities = [Game::class], version = 1, exportSchema = false)
abstract class RawgDatabase : RoomDatabase() {

    abstract fun gameDao(): GameDao
}