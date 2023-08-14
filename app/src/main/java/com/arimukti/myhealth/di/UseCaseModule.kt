package com.arimukti.myhealth.di

import com.arimukti.myhealth.domain.usecase.*
import com.arimukti.myhealth.domain.repository.MyHealthRepository
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
    fun provideNewsHeadlines(myHealthRepository: MyHealthRepository): GetNewsHeadlineUseCase {
        return GetNewsHeadlineUseCase(myHealthRepository)
    }

    @Singleton
    @Provides
    fun provideLogin(myHealthRepository: MyHealthRepository): LoginUseCase {
        return LoginUseCase(myHealthRepository)
    }

    @Singleton
    @Provides
    fun provideSignUp(myHealthRepository: MyHealthRepository): SignUpUseCase {
        return SignUpUseCase(myHealthRepository)
    }

    @Singleton
    @Provides
    fun providesSearchedNewsHeadlines(myHealthRepository: MyHealthRepository): GetSearchedNewsUseCase {
        return GetSearchedNewsUseCase(myHealthRepository)
    }

    @Singleton
    @Provides
    fun providesSavedNews(myHealthRepository: MyHealthRepository): SaveNewsUseCase {
        return SaveNewsUseCase(myHealthRepository)
    }

    @Singleton
    @Provides
    fun providesGetSavedNewsUseCase(myHealthRepository: MyHealthRepository): GetSaveNewsUseCase {
        return GetSaveNewsUseCase(myHealthRepository)
    }

    @Singleton
    @Provides
    fun providesDeleteNewsUseCase(myHealthRepository: MyHealthRepository): DeleteSaveNewsUseCase {
        return DeleteSaveNewsUseCase(myHealthRepository)
    }


}
















