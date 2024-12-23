package com.example.retromvvm2

import android.app.Application
import com.example.retromvvm2.api.RetrofitBuilder
import com.example.retromvvm2.api.UserApi
import com.example.retromvvm2.repository.Repository
import com.example.retromvvm2.room.UserDatabase

class UserApplication : Application() {

    lateinit var repository: Repository
    override fun onCreate() {
        super.onCreate()
        initialize()
    }

    private fun initialize() {
        val UserApi = RetrofitBuilder.getInstance().create(UserApi::class.java)
        val database = UserDatabase.getInstance(applicationContext)
        repository = Repository(UserApi, database)
    }
}