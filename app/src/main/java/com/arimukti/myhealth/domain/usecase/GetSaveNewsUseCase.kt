package com.arimukti.myhealth.domain.usecase

import com.arimukti.myhealth.data.model.Article
import com.arimukti.myhealth.domain.repository.MyHealthRepository
import kotlinx.coroutines.flow.Flow


class GetSaveNewsUseCase(private val repository: MyHealthRepository) {

    fun execute(): Flow<List<Article>> {
        return repository.getSavedNews()
    }

}