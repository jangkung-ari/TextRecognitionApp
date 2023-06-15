package com.arimukti.myhealth.domain.usecase

import com.arimukti.myhealth.data.model.Article
import com.arimukti.myhealth.domain.repository.MyHealthRepository

class SaveNewsUseCase(private val repository: MyHealthRepository) {

    suspend fun execute(article: Article) {
        repository.saveNews(article)
    }

}