package com.example.flickerassesment.screens

import com.example.flickerassesment.data.models.Media

data class FormattedImageData(
    val media : Media,
    val title: String,
    val description: String,
    val author: String,
    val publishedDate: String
)
