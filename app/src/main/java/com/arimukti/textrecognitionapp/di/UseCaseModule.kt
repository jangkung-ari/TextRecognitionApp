package com.arimukti.textrecognitionapp.di

import com.arimukti.textrecognitionapp.domain.usecase.DeleteSaveNewsUseCase
import com.arimukti.textrecognitionapp.domain.usecase.*
import com.arimukti.textrecognitionapp.domain.repository.AppRepository
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
    fun provideNewsHeadlines(appRepository: AppRepository): GetNewsHeadlineUseCase {
        return GetNewsHeadlineUseCase(appRepository)
    }

    @Singleton
    @Provides
    fun provideLogin(appRepository: AppRepository): LoginUseCase {
        return LoginUseCase(appRepository)
    }

    @Singleton
    @Provides
    fun provideSignUp(appRepository: AppRepository): SignUpUseCase {
        return SignUpUseCase(appRepository)
    }

    @Singleton
    @Provides
    fun providesSearchedNewsHeadlines(appRepository: AppRepository): GetSearchedNewsUseCase {
        return GetSearchedNewsUseCase(appRepository)
    }

    @Singleton
    @Provides
    fun providesSavedNews(appRepository: AppRepository): SaveNewsUseCase {
        return SaveNewsUseCase(appRepository)
    }

    @Singleton
    @Provides
    fun providesGetSavedNewsUseCase(appRepository: AppRepository): GetSaveNewsUseCase {
        return GetSaveNewsUseCase(appRepository)
    }

    @Singleton
    @Provides
    fun providesDeleteNewsUseCase(appRepository: AppRepository): DeleteSaveNewsUseCase {
        return DeleteSaveNewsUseCase(appRepository)
    }


}
















