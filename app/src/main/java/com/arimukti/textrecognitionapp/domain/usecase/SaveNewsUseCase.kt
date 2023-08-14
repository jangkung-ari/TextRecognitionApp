package com.arimukti.textrecognitionapp.domain.usecase

import com.arimukti.textrecognitionapp.data.model.Article
import com.arimukti.textrecognitionapp.domain.repository.AppRepository

class SaveNewsUseCase(private val repository: AppRepository) {

    suspend fun execute(article: Article) {
        repository.saveNews(article)
    }

}