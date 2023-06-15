package com.arimukti.myhealth.domain.usecase

import com.arimukti.myhealth.data.model.ApiResponse
import com.arimukti.myhealth.data.util.Resource
import com.arimukti.myhealth.domain.repository.MyHealthRepository

class GetNewsHeadlineUseCase(private val repository: MyHealthRepository) {

    suspend fun execute(country: String, page: Int, category: String): Resource<ApiResponse> {
        return repository.getNewsHeadlines(country, page, category)
    }

}