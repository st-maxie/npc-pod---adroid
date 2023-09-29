package com.maxwell.nlpcpod.utils

//sealed class Resourse<T> {
//
//    data class Success<T>(data):Resourse(data)
//}

sealed class Response<out T> {
    object Loading: Response<Nothing>()

    data class Success<out T>(
        val data: T
    ): Response<T>()

    data class Failure(
        val e: Exception?
    ): Response<Nothing>()
}