package com.arimukti.myhealth.domain.usecase

import com.arimukti.myhealth.data.model.SignUpRequest
import com.arimukti.myhealth.data.model.SignUpResponse
import com.arimukti.myhealth.data.util.Resource
import com.arimukti.myhealth.domain.repository.MyHealthRepository

class SignUpUseCase(private val repository: MyHealthRepository) {

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