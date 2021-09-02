package com.example.gameapp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.gameapp.data.model.game.Game

@Database(entities = [Game::class], version = 1, exportSchema = false)
abstract class RawgDatabase : RoomDatabase() {

    abstract fun gameDao(): GameDao
}
