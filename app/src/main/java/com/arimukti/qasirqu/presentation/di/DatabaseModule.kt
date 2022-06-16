package com.arimukti.qasirqu.presentation.di

import android.app.Application
import androidx.room.Room
import com.arimukti.qasirqu.data.db.ArticleDao
import com.arimukti.qasirqu.data.db.ArticleDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun providesNewsDatabase(app:Application) : ArticleDatabase {
        return Room.databaseBuilder(app, ArticleDatabase::class.java,"news_db")
            .fallbackToDestructiveMigration()
            .build()
    }


    @Singleton
    @Provides
    fun providesNewsDao(articleDatabase: ArticleDatabase) : ArticleDao {
        return articleDatabase.getArticleDao()
    }

}















