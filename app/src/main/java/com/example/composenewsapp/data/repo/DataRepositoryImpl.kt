package com.example.composenewsapp.data.repo

import com.example.composenewsapp.data.local.NewsDao
import com.example.composenewsapp.domain.model.Article
import com.example.composenewsapp.domain.repo.DataRepository
import kotlinx.coroutines.flow.Flow

class DataRepositoryImpl(
    private val newsDao: NewsDao
) : DataRepository {
    override suspend fun upsertArticle(article: Article) {
        newsDao.upsert(article)
    }

    override suspend fun deleteArticle(article: Article) {
        newsDao.delete(article)
    }

    override suspend fun getArticle(url: String): Article? {
        return newsDao.getArticle(url)
    }

    override fun getArticles(): Flow<List<Article>> {
        return newsDao.getArticles()
    }

}