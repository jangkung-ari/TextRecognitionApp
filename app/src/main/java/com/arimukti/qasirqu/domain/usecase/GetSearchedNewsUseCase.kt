package com.arimukti.qasirqu.domain.usecase

import com.arimukti.qasirqu.data.model.ApiResponse
import com.arimukti.qasirqu.data.util.Resource
import com.arimukti.qasirqu.domain.repository.NewsRepository


class GetSearchedNewsUseCase(private val repository: NewsRepository) {

    suspend fun execute(country:String,category : String,page : Int,searchQuery : String) : Resource<ApiResponse> {
        return repository.getSearchedNews(country,page,category,searchQuery)
    }

}