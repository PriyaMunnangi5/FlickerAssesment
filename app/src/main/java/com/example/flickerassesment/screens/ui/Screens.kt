package com.example.flickerassesment.screens.ui

interface Screens {
    val route: String
}

object HomeScreen: Screens {
    override val route: String
        get() = "home"
}

object ImageDetailScreen: Screens {
    override val route: String
        get() = "image_details"
}