package com.example.composenewsapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.composenewsapp.domain.model.Article

@Database(entities = [Article::class], version = 2)
@TypeConverters(NewsTypeConverters::class)
abstract class NewsDatabase: RoomDatabase() {

    abstract val newsDao: NewsDao

}