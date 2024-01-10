package com.example.composenewsapp.presentation.search

import androidx.paging.PagingData
import com.example.composenewsapp.domain.model.Article
import kotlinx.coroutines.flow.Flow

data class SearchState(
    val searchQuery: String = "",
    val articles: Flow<PagingData<Article>>? = null
)