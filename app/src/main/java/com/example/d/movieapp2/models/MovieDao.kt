package com.example.d.movieapp2.models

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface MovieDao {

    @Insert
    suspend fun insertAll(vararg movies: MovieModel): List<Long>

    @Query("SELECT * FROM moviemodel")
    suspend fun getAllMovies(): List<MovieModel>

    @Query("SELECT * FROM moviemodel WHERE uuid = :movieId")
    suspend fun getMovie(movieId: Int): MovieModel

    @Query("DELETE FROM movieModel")
    suspend fun deleteAllMovies()

}