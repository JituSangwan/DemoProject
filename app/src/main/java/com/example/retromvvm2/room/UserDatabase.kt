package com.example.retromvvm2.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.retromvvm2.model.AlbumListItem

@Database(entities = [AlbumListItem::class], version = 1)
abstract class UserDatabase: RoomDatabase() {
    abstract fun roomDao(): RoomDao

    companion object {
        private var instance: UserDatabase? = null

        @Synchronized
        fun getInstance(context: Context): UserDatabase {
            if (instance == null)
                instance = Room.databaseBuilder(
                    context.applicationContext, UserDatabase::class.java,
                    "note_database"
                ).build()

            return instance!!

        }
    }
}