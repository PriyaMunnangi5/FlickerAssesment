package com.example.flickerassesment.di

import com.example.flickerassesment.data.repository.FlickerImageRepository
import com.example.flickerassesment.data.repository.FlickerImageRepositoryImpl
import com.example.flickerassesment.screens.FlickerImageViewModelImpl
import com.example.flickerassesment.screens.FlickerViewModel
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun provideFlickerImageRepository(
       flickerImageRepositoryImpl: FlickerImageRepositoryImpl
    ): FlickerImageRepository

    @Binds
    @Singleton
    abstract fun provideFlickerViewModel(
        flickerImageViewModelImpl: FlickerImageViewModelImpl
    ): FlickerViewModel
}