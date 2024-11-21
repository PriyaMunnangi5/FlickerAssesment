package com.example.flickerassesment.data.models

data class ApiResponse(
    val title :String,
    val link :String,
    val description: String,
    val modified: String,
    val generator: String,
    val items: List<ImageItem>
)
