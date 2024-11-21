package com.example.flickerassesment.screens

import android.text.Html
import android.text.Html.FROM_HTML_MODE_LEGACY
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.flickerassesment.DISPLAY_DATE_FORMAT
import com.example.flickerassesment.EMPTY_STRING
import com.example.flickerassesment.FLICKER_ERROR_MESSAGE
import com.example.flickerassesment.FLICKER_INITIAL_MESSAGE
import com.example.flickerassesment.RESPONSE_DATE_FORMAT
import com.example.flickerassesment.UTC
import com.example.flickerassesment.data.models.ApiResponse
import com.example.flickerassesment.data.models.ImageItem
import com.example.flickerassesment.data.repository.FlickerImageRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Locale
import java.util.TimeZone
import javax.inject.Inject

@HiltViewModel
class FlickerImageViewModelImpl @Inject constructor(
    private val flickerImageRepository: FlickerImageRepository
): FlickerViewModel, ViewModel() {
    private val _uiState= MutableStateFlow<FlickerUiState>(FlickerUiState.InitialStage(
        FLICKER_INITIAL_MESSAGE
    ))

    val uiState
        get() = _uiState

    override fun getTheImagesFromTheTag(tags: String){
        _uiState.value = FlickerUiState.Loader
        viewModelScope.launch {
            val response = flickerImageRepository.getFlickerImages(tags = tags)
            if(response.isSuccessful()) {
                _uiState.value = FlickerUiState.Success(
                    response = response.body() as ApiResponse
                )
            } else {
                _uiState.value = FlickerUiState.Error(
                    FLICKER_ERROR_MESSAGE
                )
            }

        }
    }

    fun getTheFormattedImageObject(item: ImageItem): FormattedImageData{
        return FormattedImageData(
            media = item.media,
            title = item.title,
            description = getHtmlContentFromTheRawString(item.description),
            author = item.author,
            publishedDate = formatDate(item.published)
        )

    }

    fun getHtmlContentFromTheRawString(rawString: String): String{
        return Html.fromHtml(rawString, FROM_HTML_MODE_LEGACY).toString()
    }

    fun formatDate(date: String?): String {
        date?.let {
            val inputFormat = SimpleDateFormat(RESPONSE_DATE_FORMAT, Locale.getDefault())
            inputFormat.timeZone = TimeZone.getTimeZone(UTC)
            val outputFormat = SimpleDateFormat(DISPLAY_DATE_FORMAT, Locale.getDefault())
            val inputDate = inputFormat.parse(date)
            return inputDate?.let {
                outputFormat.format(it)
            } ?: EMPTY_STRING
        }?: return EMPTY_STRING
    }

}