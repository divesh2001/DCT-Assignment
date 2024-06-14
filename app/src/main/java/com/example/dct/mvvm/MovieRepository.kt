package com.example.dct.mvvm

import com.example.dct.rest.MovieResponse
import com.example.dct.rest.RetrofitInstance

class MovieRepository {
    private val apiService = RetrofitInstance.api

    suspend fun getTrendingMovies(apiKey: String, page: Int): MovieResponse {
        return apiService.getTrendingMovies(apiKey, page)
    }
}