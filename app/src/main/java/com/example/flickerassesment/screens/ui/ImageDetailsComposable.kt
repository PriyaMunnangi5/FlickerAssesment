package com.example.flickerassesment.screens.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.flickerassesment.screens.FormattedImageData

@Composable
fun ImageDetailsComposable(
    formattedImageData: FormattedImageData
) {

    Column(modifier = Modifier.fillMaxWidth()) {

        AsyncImage(
            model = formattedImageData.media.m,
            contentDescription = null,
            alignment = Alignment.Center,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.padding(horizontal = 5.dp,
                vertical = 5.dp)
                .align(Alignment.CenterHorizontally)
        )
        Text(text = formattedImageData.title,
                style = MaterialTheme.typography.titleMedium)

        Text(text = formattedImageData.description,
            style = MaterialTheme.typography.bodyMedium)

        Row(
            modifier= Modifier.fillMaxWidth()
        ) {
            Text(text = "Author",
                modifier = Modifier.weight(0.5f))
            Text(text = formattedImageData.author,
                modifier = Modifier.weight(0.5f))
        }
        Row(
            modifier= Modifier.fillMaxWidth()
        ) {
            Text(text = "Published Date",
                modifier = Modifier.weight(0.5f))
            Text(text = formattedImageData.publishedDate,
                modifier = Modifier.weight(0.5f))
        }
    }
}