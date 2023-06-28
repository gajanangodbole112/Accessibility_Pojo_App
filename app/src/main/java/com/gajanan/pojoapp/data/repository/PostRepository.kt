package com.gajanan.pojoapp.data.repository

import androidx.room.withTransaction
import com.gajanan.pojoapp.domain.localDatabase.PostDatabase
import com.gajanan.pojoapp.domain.localDatabase.networkBoundResource
import com.gajanan.pojoapp.domain.network.MyApi
import javax.inject.Inject

class PostRepository @Inject constructor(
    private val api: MyApi,
    private val db: PostDatabase
) {

    private val postDao = db.postDao()

    fun getPosts() = networkBoundResource(
        query = {
            postDao.getAllPosts()
        },
        fetch = {
            api.getPosts()
        },
        saveFetchResult = { result ->
            db.withTransaction {
                postDao.insertPost(result.body()!!)
            }
        }
    )
}