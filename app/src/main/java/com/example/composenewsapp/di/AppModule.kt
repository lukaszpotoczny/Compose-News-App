package com.example.composenewsapp.di

import android.app.Application
import androidx.room.Room
import com.example.composenewsapp.data.LocalUserManagerImpl
import com.example.composenewsapp.data.local.NewsDao
import com.example.composenewsapp.data.local.NewsDatabase
import com.example.composenewsapp.data.local.NewsTypeConverters
import com.example.composenewsapp.data.remote.NewsApi
import com.example.composenewsapp.data.repo.DataRepositoryImpl
import com.example.composenewsapp.data.repo.NewsRepositoryImpl
import com.example.composenewsapp.domain.manager.LocalUserManager
import com.example.composenewsapp.domain.repo.DataRepository
import com.example.composenewsapp.domain.repo.NewsRepository
import com.example.composenewsapp.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocalUserManager(app: Application): LocalUserManager = LocalUserManagerImpl(app)

    @Provides
    @Singleton
    fun providesNewsApi(): NewsApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApi::class.java)
    }

    @Provides
    @Singleton
    fun providesNewsRepo(newsApi: NewsApi): NewsRepository = NewsRepositoryImpl(newsApi)

    @Provides
    @Singleton
    fun provideNewsDatabase(app: Application): NewsDatabase {
        return Room.databaseBuilder(
            context = app,
            klass = NewsDatabase::class.java,
            name = Constants.NEWS_DATABASE_NAME
        ).addTypeConverter(NewsTypeConverters())
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideNewsDao(newsDB: NewsDatabase): NewsDao = newsDB.newsDao

    @Provides
    @Singleton
    fun providesDataRepo(newsDao: NewsDao): DataRepository = DataRepositoryImpl(newsDao)
}