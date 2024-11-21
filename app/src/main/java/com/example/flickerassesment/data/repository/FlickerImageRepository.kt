package com.example.flickerassesment.data.repository

import com.example.flickerassesment.data.models.ApiResponse
import com.example.flickerassesment.data.models.ResponseWrapper
import retrofit2.Response

interface FlickerImageRepository {
    suspend fun getFlickerImages(tags: String) : ResponseWrapper<ApiResponse>
}