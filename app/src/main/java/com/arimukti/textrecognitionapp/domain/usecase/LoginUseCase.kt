package com.arimukti.textrecognitionapp.domain.usecase

import com.arimukti.textrecognitionapp.data.model.LoginResponse
import com.arimukti.textrecognitionapp.data.util.Resource
import com.arimukti.textrecognitionapp.domain.repository.AppRepository

class LoginUseCase(private val repository: AppRepository) {

    suspend fun invoke(username: String, password: String): Resource<LoginResponse> {
        return repository.login(username, password)
    }
}