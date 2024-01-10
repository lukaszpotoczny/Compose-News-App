package com.example.composenewsapp.presentation.details

import com.example.composenewsapp.domain.model.Article

sealed class DetailsEvent {

    data class CheckBookmark(val article: Article): DetailsEvent()
    data class UpsertDeleteArticle(val article: Article): DetailsEvent()
    object RemoveSideEffect: DetailsEvent()
}