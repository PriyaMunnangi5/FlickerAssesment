package com.example.flickerassesment.data.models

import retrofit2.Response


open class ResponseWrapper<T>(private val response: Response<T>) {
    fun isSuccessful(): Boolean = response.isSuccessful
    fun body(): T? = response.body()
}