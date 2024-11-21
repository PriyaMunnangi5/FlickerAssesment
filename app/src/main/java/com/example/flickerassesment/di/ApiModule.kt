package com.example.flickerassesment.di

import com.example.flickerassesment.data.services.BASE_URL
import com.example.flickerassesment.data.services.FlickerApiCalls
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object ApiModule{

    @Provides
    @Singleton
    fun provideMyApiCallsRetrofitBuilder() : FlickerApiCalls {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(FlickerApiCalls::class.java)
    }
}