package com.puntogris.conexachallenge.domain

import com.puntogris.conexachallenge.utils.Resource
import kotlinx.coroutines.flow.Flow

interface Repository {

    fun getPosts(): Flow<Resource<List<Post>>>

    fun getUsers(): Flow<Resource<List<User>>>
}

