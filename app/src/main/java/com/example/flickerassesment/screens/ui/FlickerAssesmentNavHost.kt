package com.example.flickerassesment.screens.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.flickerassesment.data.models.ImageItem
import com.example.flickerassesment.screens.FlickerImageViewModelImpl

@Composable
fun FlickerAssesmentNavHost(
    navHostController: NavHostController,
    modifier: Modifier,
    flickerImageViewModelImpl: FlickerImageViewModelImpl
) {

    lateinit var imageItem: ImageItem

    NavHost(
        navController = navHostController,
        startDestination = HomeScreen.route,
        modifier = Modifier
    ) {
        composable(route = HomeScreen.route) {
            HomeComposable(
                flickerImageViewModelImpl,
                modifier,
                navigateToImageDetails = {
                    imageItem = it
                    navHostController.navigate(ImageDetailScreen.route)
                }
            )
        }

        composable(route = ImageDetailScreen.route) {
            ImageDetailsComposable(
                formattedImageData = flickerImageViewModelImpl.getTheFormattedImageObject(imageItem)
            )
        }
    }

}