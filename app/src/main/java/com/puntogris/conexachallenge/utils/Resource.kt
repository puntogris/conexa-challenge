package com.puntogris.conexachallenge.utils

sealed class Resource<T> {
    data class Success<T>(val value: T) : Resource<T>()
    data class Error<T>(val error: String = "Something went wrong.") : Resource<T>()
    class Loading<T> : Resource<T>()
}