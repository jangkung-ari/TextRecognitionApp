package com.arimukti.myhealth.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.arimukti.myhealth.domain.usecase.SignUpUseCase

class SignUpViewModelFactory(
    private val app: Application,
    private val signUpUseCase: SignUpUseCase,
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return SignUpViewModel(
            app,
            signUpUseCase
        ) as T
    }
}