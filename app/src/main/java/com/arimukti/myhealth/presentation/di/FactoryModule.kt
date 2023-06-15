package com.arimukti.myhealth.presentation.di

import android.app.Application
import com.arimukti.myhealth.domain.usecase.*
import com.arimukti.myhealth.presentation.viewmodel.LoginViewModelFactory
import com.arimukti.myhealth.presentation.viewmodel.NewsViewModelFactory
import com.arimukti.myhealth.presentation.viewmodel.SignUpViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class FactoryModule {

    @Singleton
    @Provides
    fun provideNewsViewModelFactory(
        application: Application,
        getNewsHeadlineUseCase: GetNewsHeadlineUseCase,
        getSearchedNewsUseCase: GetSearchedNewsUseCase,
        saveNewsUseCase: SaveNewsUseCase,
        getSaveNewsUseCase: GetSaveNewsUseCase,
        deleteSaveNewsUseCase: DeleteSaveNewsUseCase
    ): NewsViewModelFactory {
        return NewsViewModelFactory(
            application,
            getNewsHeadlineUseCase,
            getSearchedNewsUseCase,
            saveNewsUseCase,
            getSaveNewsUseCase,
            deleteSaveNewsUseCase
        )
    }

    @Singleton
    @Provides
    fun provideLoginViewModelFactory(
        application: Application,
        loginUseCase: LoginUseCase
    ): LoginViewModelFactory {
        return LoginViewModelFactory(
            application,
            loginUseCase
        )
    }

    @Singleton
    @Provides
    fun provideSignUpViewModelFactory(
        application: Application,
        signUpUseCase: SignUpUseCase
    ): SignUpViewModelFactory {
        return SignUpViewModelFactory(
            application,
            signUpUseCase
        )
    }
}