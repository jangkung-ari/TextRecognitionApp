package com.arimukti.myhealth.domain.usecase

import com.arimukti.myhealth.data.model.ApiResponse
import com.arimukti.myhealth.data.util.Resource
import com.arimukti.myhealth.domain.repository.MyHealthRepository


class GetSearchedNewsUseCase(private val repository: MyHealthRepository) {

    suspend fun execute(
        country: String,
        category: String,
        page: Int,
        searchQuery: String
    ): Resource<ApiResponse> {
        return repository.getSearchedNews(country, page, category, searchQuery)
    }

}