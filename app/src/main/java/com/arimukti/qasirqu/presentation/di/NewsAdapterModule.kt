package com.arimukti.qasirqu.presentation.di

import com.arimukti.qasirqu.presentation.adapter.NewsAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NewsAdapterModule {
    @Singleton
    @Provides
    fun provideNewsAdapter() : NewsAdapter {
        return NewsAdapter()
    }

}