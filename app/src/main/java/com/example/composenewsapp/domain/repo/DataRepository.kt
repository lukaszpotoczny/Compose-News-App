package com.example.composenewsapp.domain.repo

import com.example.composenewsapp.domain.model.Article
import kotlinx.coroutines.flow.Flow

interface DataRepository {

    suspend fun upsertArticle(article: Article)
    suspend fun deleteArticle(article: Article)
    suspend fun getArticle(url: String): Article?
    fun getArticles(): Flow<List<Article>>
}