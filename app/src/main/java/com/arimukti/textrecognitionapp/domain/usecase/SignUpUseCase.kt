package com.arimukti.textrecognitionapp.domain.usecase

import com.arimukti.textrecognitionapp.data.model.SignUpRequest
import com.arimukti.textrecognitionapp.data.model.SignUpResponse
import com.arimukti.textrecognitionapp.data.util.Resource
import com.arimukti.textrecognitionapp.domain.repository.AppRepository

class SignUpUseCase(private val repository: AppRepository) {

    suspend fun invoke(
        username: String,
        email: String,
        password: String,
        phoneNumber: Int
    ): Resource<SignUpResponse> {
        return repository.signUp(
            SignUpRequest(
                username = username,
                email = email,
                password = password,
                phone_number = phoneNumber
            )
        )
    }
}