package com.example.flickerassesment.screens.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.flickerassesment.data.models.ImageItem
import com.example.flickerassesment.screens.FlickerImageViewModelImpl
import com.example.flickerassesment.screens.FlickerUiState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeComposable(
    flickerImageViewModelImpl: FlickerImageViewModelImpl,
    modifier: Modifier,
    navigateToImageDetails: (ImageItem) -> Unit
) {
    val flickerUiState by flickerImageViewModelImpl.uiState.collectAsState()

    var value by rememberSaveable { mutableStateOf("Please search the images") }

    Column {
        TextField(
            value = value,
            onValueChange = { tags ->
                value = tags
                flickerImageViewModelImpl.getTheImagesFromTheTag(tags)},
            placeholder = {
                Text(text = "Type Here")
            },
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp),
            singleLine = true,
            leadingIcon = {
                Icon(Icons.Default.Search, contentDescription = "Search Icon")
            }
        )
        when (flickerUiState) {
            is FlickerUiState.Error ->
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text((flickerUiState as FlickerUiState.Error).errorMessage)
                }
            is FlickerUiState.InitialStage ->
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text((flickerUiState as FlickerUiState.InitialStage).displayMessage)
                }
            FlickerUiState.Loader ->
                Column( modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally) {
                    CircularProgressIndicator(
                        modifier = Modifier.width(64.dp),
                        color = MaterialTheme.colorScheme.secondary,
                        trackColor = MaterialTheme.colorScheme.surfaceVariant
                    )
                }

            is FlickerUiState.Success ->
                FlickerSearchResultsComposable(flickerUiState as FlickerUiState.Success, Modifier, navigateToImageDetails)
        }
    }
}