package com.example.composenewsapp.presentation.home

import androidx.lifecycle.ViewModel
import com.example.composenewsapp.domain.repo.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    newsRepo: NewsRepository
): ViewModel() {

    val news = newsRepo.getNews(sources = listOf("bbc-news, abc-news"))

}