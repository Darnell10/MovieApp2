package com.example.d.movieapp2.models

import com.google.gson.annotations.SerializedName


data class Movie_Model(

        @SerializedName("vote_count")
        val vote_count: Int?,

        @SerializedName("id")
        val id: Int?,

        @SerializedName("video")
        val video: Boolean?,

        @SerializedName("vote_average")
        val voteAverage: Float?,

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

        @SerializedName("overview")
        val overview: String?,

        @SerializedName("release_date")
        val releaseDate: String?
) {}

data class Movie_Response(

        @SerializedName("results")
        val results: ArrayList<Movie_Model>?,

        @SerializedName("total_pages")
        val totalPages: Int?,

        @SerializedName("total_results")
        val totalResults: Int?,

        @SerializedName("pages")
        val page: String?

) {}