package com.example.d.movieapp2.models

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(MovieModel::class), version = 1, exportSchema = false)
abstract class MovieDataBase : RoomDatabase() {
    abstract fun movieDao(): MovieDao




    private fun buildDataBase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            MovieDataBase::class.java,
            "moviedatabase"
    ).build()


}