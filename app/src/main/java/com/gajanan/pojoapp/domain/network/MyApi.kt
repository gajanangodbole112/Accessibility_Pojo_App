package com.gajanan.pojoapp.domain.network

import com.gajanan.pojoapp.data.modals.Post
import retrofit2.Response
import retrofit2.http.GET

interface MyApi {

    @GET(EndPoints.POSTS)
    suspend fun getPosts() : Response<List<Post>>
}