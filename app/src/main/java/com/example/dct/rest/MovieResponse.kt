package com.example.dct.rest

data class MovieResponse( val page: Int, val results: List<Movie>)

data class Movie(
    val id: Int,
    val title: String,
    val poster_path: String
)
