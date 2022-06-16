package com.arimukti.qasirqu.domain.usecase

import com.arimukti.qasirqu.data.model.ApiResponse
import com.arimukti.qasirqu.data.util.Resource
import com.arimukti.qasirqu.domain.repository.NewsRepository

class GetNewsHeadlineUseCase(private val repository: NewsRepository) {

    suspend fun execute(country: String, page: Int, category: String): Resource<ApiResponse> {
        return repository.getNewsHeadlines(country, page, category)
    }

}