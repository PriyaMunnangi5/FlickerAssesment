package com.example.flickerassesment.screens

import com.example.flickerassesment.data.models.ApiResponse

sealed class FlickerUiState {
    object Loader: FlickerUiState()
    data class Success(val response: ApiResponse) : FlickerUiState()
    data class Error(val errorMessage: String): FlickerUiState()
    data class InitialStage(val displayMessage: String): FlickerUiState()
}