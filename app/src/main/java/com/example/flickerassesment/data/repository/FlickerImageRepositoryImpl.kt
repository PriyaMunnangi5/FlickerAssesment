package com.example.flickerassesment.data.repository

import com.example.flickerassesment.data.models.ApiResponse
import com.example.flickerassesment.data.models.ResponseWrapper
import com.example.flickerassesment.data.services.FlickerApiCalls
import retrofit2.Response
import javax.inject.Inject

class FlickerImageRepositoryImpl @Inject constructor(
    private val flickerApiCalls: FlickerApiCalls
) : FlickerImageRepository {

    override suspend fun getFlickerImages(tags: String): ResponseWrapper<ApiResponse> {
       return ResponseWrapper(flickerApiCalls.getImagesWithTags(tags = tags))
    }


}