package com.example.retromvvm2.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.example.PopularMovies
import com.example.retromvvm2.api.UserApi
import com.example.retromvvm2.model.AlbumListItem
import com.example.retromvvm2.room.UserDatabase

class Repository(
    private val userApi: UserApi,
    private val userDatabase: UserDatabase,
) {

    private val userdata = MutableLiveData<List<AlbumListItem>>()
    private val popularMovies = MutableLiveData<PopularMovies>()

    val movies: LiveData<PopularMovies>
        get() = popularMovies

    val user: LiveData<List<AlbumListItem>>
        get() = userdata


    suspend fun getUserAlbum() {
    //    if (NetworkUtils.isInternetAvailable(applicationContext)){
            val result = userApi.getPhotos()
            if (result.body()!=null){
                userDatabase.roomDao().addUserData(result.body()!!)
                userdata.postValue(result.body())
            }
        }

    suspend fun getPopularMovie(key: String) {

        val result = userApi.getPopularMovies(key)
        if (result.body()!=null){
            popularMovies.postValue(result.body())
        }
    }
}
