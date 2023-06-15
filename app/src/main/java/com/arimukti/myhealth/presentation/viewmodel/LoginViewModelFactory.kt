package com.arimukti.myhealth.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.arimukti.myhealth.domain.usecase.LoginUseCase

class LoginViewModelFactory(
    private val app: Application,
    private val loginUseCase: LoginUseCase,
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return LoginViewModel(
            app,
            loginUseCase
        ) as T
    }
}