package com.arimukti.textrecognitionapp.domain.usecase

import com.arimukti.textrecognitionapp.data.model.Article
import com.arimukti.textrecognitionapp.domain.repository.AppRepository
import kotlinx.coroutines.flow.Flow


class GetSaveNewsUseCase(private val repository: AppRepository) {

    fun execute(): Flow<List<Article>> {
        return repository.getSavedNews()
    }

}