package com.example.gameapp.presentation.di.core

import android.content.Context
import androidx.room.Room
import com.example.gameapp.data.db.GameDao
import com.example.gameapp.data.db.RawgDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataBaseModule {

    @Singleton
    @Provides
    fun provideGameDatabase(context: Context): RawgDatabase {
        return Room.databaseBuilder(context, RawgDatabase::class.java, "game_database")
            .build()
    }

    @Singleton
    @Provides
    fun provideGameDao(rawgDatabase: RawgDatabase): GameDao {
        return rawgDatabase.gameDao()
    }
}
