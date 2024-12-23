package com.example.retromvvm2.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retromvvm2.R
import com.example.retromvvm2.UserApplication
import com.example.retromvvm2.api.RetrofitBuilder
import com.example.retromvvm2.api.UserApi
import com.example.retromvvm2.model.AlbumListItem
import com.example.retromvvm2.repository.Repository
import com.example.retromvvm2.viewmodel.MainViewModel
import com.example.retromvvm2.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    val API_Key = "6172f7b4e175edb6bf01088aebd7e1a7"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val repository = (application as UserApplication).repository
        viewModel =
            ViewModelProvider(this, ViewModelFactory(repository)).get(MainViewModel::class.java)

        btnMovies.setOnClickListener{
            viewModel.getPopularMovie(API_Key)
        }

        viewModel.movies.observe(this) {
//            showUserData(it)
        }

        btnUsers.setOnClickListener{
            viewModel.user.observe(this) {
                showUserData(it)
            }
        }
    }

    private fun showUserData(user: List<AlbumListItem>) {
        recycleView.adapter = UserAdapter(this, user)
        recycleView.layoutManager = LinearLayoutManager(this)
    }
}