package com.example.composenewsapp.presentation.details

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composenewsapp.domain.model.Article
import com.example.composenewsapp.domain.repo.DataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val dataRepository: DataRepository
) : ViewModel() {

    var sideEffect by mutableStateOf<String?>(null)
        private set

    var articleState by mutableStateOf<Article?>(null)
        private set

    var isBookmark = false

    fun onEvent(event: DetailsEvent) {
        when (event) {
            is DetailsEvent.CheckBookmark -> {
                viewModelScope.launch {
                    val article = dataRepository.getArticle(event.article.url)
                    isBookmark = article != null
                    articleState = event.article
                }
            }

            is DetailsEvent.UpsertDeleteArticle -> {
                viewModelScope.launch {
                    sideEffect = if (!isBookmark) {
                        dataRepository.upsertArticle(event.article)
                        isBookmark = true
                        "Article saved"
                    } else {
                        dataRepository.deleteArticle(event.article)
                        isBookmark = false
                        "Article deleted"
                    }
                }
            }

            is DetailsEvent.RemoveSideEffect -> {
                sideEffect = null
            }
        }
    }


}