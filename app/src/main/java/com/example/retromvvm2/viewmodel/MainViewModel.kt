package com.example.retromvvm2.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.example.Movies
import com.example.example.PopularMovies
import com.example.retromvvm2.model.AlbumListItem
import com.example.retromvvm2.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val repository: Repository) : ViewModel() {

    val user: LiveData<List<AlbumListItem>>
        get() = repository.user

    val movies: LiveData<PopularMovies>
        get() = repository.movies

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getUserAlbum()
        }
    }

    // Methods for getting list of movies
//    var popularMovieList = MutableLiveData<PopularMovies>()
    fun getPopularMovie(key: String) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getPopularMovie(key)
        }

    }
}