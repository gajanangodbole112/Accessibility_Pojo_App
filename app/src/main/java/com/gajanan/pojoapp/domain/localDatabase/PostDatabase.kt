package com.gajanan.pojoapp.domain.localDatabase

import androidx.room.Database
import androidx.room.RoomDatabase
import com.gajanan.pojoapp.data.modals.Post

@Database(entities = [Post::class], version = 1)
abstract class PostDatabase : RoomDatabase() {
    abstract fun postDao(): PostDao
}