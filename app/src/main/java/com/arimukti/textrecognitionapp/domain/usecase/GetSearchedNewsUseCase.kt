package com.arimukti.textrecognitionapp.domain.usecase

import com.arimukti.textrecognitionapp.data.model.ApiResponse
import com.arimukti.textrecognitionapp.data.util.Resource
import com.arimukti.textrecognitionapp.domain.repository.AppRepository


class GetSearchedNewsUseCase(private val repository: AppRepository) {

    suspend fun execute(
        country: String,
        category: String,
        page: Int,
        searchQuery: String
    ): Resource<ApiResponse> {
        return repository.getSearchedNews(country, page, category, searchQuery)
    }

}