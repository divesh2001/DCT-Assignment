package com.example.dct.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dct.rest.Movie
import kotlinx.coroutines.launch

// MovieViewModel.kt
class MovieViewModel : ViewModel() {
    private val repository = MovieRepository()
    private val _movies = MutableLiveData<List<Movie>>()
    val movies: LiveData<List<Movie>> get() = _movies
    private val _page = MutableLiveData<Int>().apply { value = 1 }
    val page: LiveData<Int> get() = _page

    private val apiKey = "c40e50164815a1166ece02ec599b7c6d"

    init {
        loadMovies()
    }

    fun loadMovies() {
        viewModelScope.launch {
            try {
                val response = repository.getTrendingMovies(apiKey, _page.value ?: 1)
                _movies.value = response.results
            } catch (e: Exception) {
                // Handle exception
            }
        }
    }

    fun loadMoreMovies() {
        _page.value = (_page.value ?: 1) + 1
        loadMovies()
    }
}
