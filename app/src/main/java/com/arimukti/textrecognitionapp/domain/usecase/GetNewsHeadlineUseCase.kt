package com.arimukti.textrecognitionapp.domain.usecase

import com.arimukti.textrecognitionapp.data.model.ApiResponse
import com.arimukti.textrecognitionapp.data.util.Resource
import com.arimukti.textrecognitionapp.domain.repository.AppRepository

class GetNewsHeadlineUseCase(private val repository: AppRepository) {

    suspend fun execute(country: String, page: Int, category: String): Resource<ApiResponse> {
        return repository.getNewsHeadlines(country, page, category)
    }

}