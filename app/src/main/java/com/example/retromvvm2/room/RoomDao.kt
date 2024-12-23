package com.example.retromvvm2.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.retromvvm2.model.AlbumListItem

@Dao
interface RoomDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addUserData(user :List<AlbumListItem>)

    @Query("SELECT * FROM user")
    suspend fun getUserData(): List<AlbumListItem>

}