package com.example.retromvvm2.api

import com.example.example.PopularMovies
import com.example.retromvvm2.model.AlbumListItem
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface UserApi {

    @GET("photos")
    suspend fun getPhotos(): Response<List<AlbumListItem>>

    // EndURL for TMDB movie
    @GET("movie/popular")
    suspend fun getPopularMovies(@Query("api_key") key: String): Response<PopularMovies>
}