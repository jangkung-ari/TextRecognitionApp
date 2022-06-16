package com.arimukti.qasirqu.domain.usecase

import com.arimukti.qasirqu.data.model.Article
import com.arimukti.qasirqu.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow


class GetSaveNewsUseCase(private val repository: NewsRepository) {

    fun execute() : Flow<List<Article>> {
        return repository.getSavedNews()
    }

}