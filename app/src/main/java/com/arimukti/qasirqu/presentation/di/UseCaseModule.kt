package com.arimukti.qasirqu.presentation.di

import com.arimukti.qasirqu.domain.usecase.*
import com.arimukti.qasirqu.domain.repository.NewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Singleton
    @Provides
    fun provideNewsHeadlines(newsRepository: NewsRepository) : GetNewsHeadlineUseCase {
        return GetNewsHeadlineUseCase(newsRepository)
    }

    @Singleton
    @Provides
    fun providesSearchedNewsHeadlines(newsRepository: NewsRepository) : GetSearchedNewsUseCase {
        return GetSearchedNewsUseCase(newsRepository)
    }

    @Singleton
    @Provides
    fun providesSavedNews(newsRepository: NewsRepository) : SaveNewsUseCase {
        return SaveNewsUseCase(newsRepository)
    }

    @Singleton
    @Provides
    fun providesGetSavedNewsUseCase(newsRepository: NewsRepository) : GetSaveNewsUseCase {
        return GetSaveNewsUseCase(newsRepository)
    }

    @Singleton
    @Provides
    fun providesDeleteNewsUseCase(newsRepository: NewsRepository) : DeleteSaveNewsUseCase {
        return DeleteSaveNewsUseCase(newsRepository)
    }


}
















