package com.example.gameapp

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.gameapp.data.model.game.Game
import com.example.gameapp.data.model.game.GameList

@Dao
interface GameDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGames(game: List<Game>)

    @Query("DELETE FROM GAME_TABLE")
    suspend fun deleAllGames()

    @Query("SELECT * FROM GAME_TABLE")
    suspend fun getGames(): List<Game>
}