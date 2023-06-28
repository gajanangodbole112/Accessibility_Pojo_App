package com.gajanan.pojoapp.domain.localDatabase

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.gajanan.pojoapp.data.modals.Post
import kotlinx.coroutines.flow.Flow

@Dao
interface PostDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPost(posts: List<Post>)

    @Query("SELECT * FROM post_table")
    fun getAllPosts(): Flow<List<Post>>

    @Query("DELETE FROM post_table")
    suspend fun deleteAllPosts()
}