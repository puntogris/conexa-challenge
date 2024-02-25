package com.puntogris.conexachallenge.data.api

import com.puntogris.conexachallenge.data.models.PostDto
import com.puntogris.conexachallenge.data.models.UserDto
import retrofit2.http.GET

interface ApiService {

    @GET("posts")
    suspend fun getPosts(): List<PostDto>

    @GET("users")
    suspend fun getUsers(): List<UserDto>

    companion object {
        const val BASE_URL = "https://jsonplaceholder.org/"
    }
}

