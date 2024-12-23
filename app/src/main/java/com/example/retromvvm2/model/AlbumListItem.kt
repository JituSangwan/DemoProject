package com.example.retromvvm2.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class AlbumListItem(
    val albumId: Int,
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val thumbnailUrl: String,
    val title: String,
    val url: String
)