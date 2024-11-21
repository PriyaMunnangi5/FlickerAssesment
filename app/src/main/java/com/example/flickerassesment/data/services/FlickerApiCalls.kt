package com.example.flickerassesment.data.services

import com.example.flickerassesment.data.models.ApiResponse
import retrofit2.Response

import retrofit2.http.GET
import retrofit2.http.Query

const val BASE_URL = "https://www.flickr.com/"

interface FlickerApiCalls {

   @GET("services/feeds/photos_public.gne")
    suspend fun getImagesWithTags(@Query("format") format: String = "json",
                                  @Query("nojsoncallback") noJsonCallBack: Int = 1,
                                  @Query("tags") tags: String) : Response<ApiResponse>
}