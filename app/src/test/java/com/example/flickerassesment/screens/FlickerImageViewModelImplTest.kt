package com.example.flickerassesment.screens

import com.example.flickerassesment.data.models.ApiResponse
import com.example.flickerassesment.data.models.ResponseWrapper
import com.example.flickerassesment.data.repository.FlickerImageRepository
import com.example.flickerassesment.screens.FlickerUiState.Success
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Assert.*

import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever
import retrofit2.Response

@RunWith(MockitoJUnitRunner::class)
class FlickerImageViewModelImplTest {

    private lateinit var viewModel: FlickerImageViewModelImpl
    @Mock
    private lateinit var flickerImageRepository: FlickerImageRepository


    private val testDispatcher = StandardTestDispatcher()

    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
        viewModel = FlickerImageViewModelImpl(
            flickerImageRepository
        )
    }

    @Test
    fun `test formatDate rertuns Empty String when date is null`() {
        val result = viewModel.formatDate(null)
        assertEquals("", result)

    }

}