package com.example.flickerassesment.screens.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.flickerassesment.data.models.ImageItem
import com.example.flickerassesment.screens.FlickerUiState

@Composable
fun FlickerSearchResultsComposable(
    success: FlickerUiState.Success,
    modifier: Modifier,
    navigateToImageDetails: (ImageItem) -> Unit
){
    LazyVerticalGrid(columns = GridCells.Fixed(3)) {

        items(success.response.items) {
            AsyncImage(
                model = it.media.m,
                contentDescription = null,
                alignment = Alignment.Center,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier.padding(horizontal = 5.dp,
                    vertical = 5.dp)
                    .clickable {
                      navigateToImageDetails(it)
                    }
            )
        }
    }
}