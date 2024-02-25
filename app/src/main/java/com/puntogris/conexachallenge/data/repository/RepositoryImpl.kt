package com.puntogris.conexachallenge.data.repository

import com.puntogris.conexachallenge.data.api.ApiService
import com.puntogris.conexachallenge.data.utils.toDomain
import com.puntogris.conexachallenge.domain.Post
import com.puntogris.conexachallenge.domain.Repository
import com.puntogris.conexachallenge.domain.User
import com.puntogris.conexachallenge.domain.DispatcherProvider
import com.puntogris.conexachallenge.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.lang.Exception

class RepositoryImpl(
    private val apiService: ApiService,
    private val dispatchers: DispatcherProvider
) : Repository {

    override fun getPosts(): Flow<Resource<List<Post>>> = flow {
        emit(Resource.Loading())

        try {
            emit(Resource.Success(apiService.getPosts().map { it.toDomain() }))
        } catch (e: Exception) {
            emit(Resource.Error("Failed fetching posts."))
        }
    }.flowOn(dispatchers.io)

    override fun getUsers(): Flow<Resource<List<User>>> = flow {
        emit(Resource.Loading())

        try {
            emit(Resource.Success(apiService.getUsers().map { it.toDomain() }))
        } catch (e: Exception) {
            emit(Resource.Error("Failed fetching users."))
        }
    }.flowOn(dispatchers.io)
}