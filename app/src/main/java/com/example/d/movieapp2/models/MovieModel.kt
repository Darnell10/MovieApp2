package com.example.d.movieapp2.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class MovieModel(


        @SerializedName("vote_count")
        val vote_count: Int?,

        @ColumnInfo(name = "id")
        @SerializedName("id")
        val id: Int?,

        @SerializedName("video")
        val video: Boolean?,

        @SerializedName("vote_average")
        val voteAverage: Float?,

        @ColumnInfo(name = "title")
        @SerializedName("title")
        val title: String?,

        @SerializedName("popularity")
        val popularity: Float?,

        @SerializedName("poster_path")
        val posterPath: String?,

        @SerializedName("original_language")
        val originalLanguage: String?,

        @SerializedName("original_title")
        val originalTitle: String?,

        @SerializedName("genre_ids")
        val genreIds: ArrayList<Int>?,

        @SerializedName("backdrop_path")
        val backdropPath: String?,

        @SerializedName("adult")
        val adult: Boolean?,

        @ColumnInfo(name = "overview")
        @SerializedName("overview")
        val overview: String?,

        @ColumnInfo(name = "release_date")
        @SerializedName("release_date")
        val releaseDate: String?
) {
    @PrimaryKey(autoGenerate = true)
    var uuid: Int = 0
}

data class MovieResponse(

        @SerializedName("results")
        val results: ArrayList<MovieModel>?,

        @SerializedName("total_pages")
        val totalPages: Int?,

        @SerializedName("total_results")
        val totalResults: Int?,

        @SerializedName("pages")
        val page: String?

) {}