package com.example.composenewsapp.presentation.bookmark

import com.example.composenewsapp.domain.model.Article

data class BookmarkState(
    val articles: List<Article> = emptyList()
)