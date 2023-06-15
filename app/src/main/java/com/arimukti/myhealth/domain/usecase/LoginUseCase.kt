package com.arimukti.myhealth.domain.usecase

import com.arimukti.myhealth.data.model.LoginResponse
import com.arimukti.myhealth.data.util.Resource
import com.arimukti.myhealth.domain.repository.MyHealthRepository

class LoginUseCase(private val repository: MyHealthRepository) {

    suspend fun invoke(username: String, password: String): Resource<LoginResponse> {
        return repository.login(username, password)
    }
}