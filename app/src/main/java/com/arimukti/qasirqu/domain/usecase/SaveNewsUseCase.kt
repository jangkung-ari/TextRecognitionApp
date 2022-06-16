package com.arimukti.qasirqu.domain.usecase

import com.arimukti.qasirqu.data.model.Article
import com.arimukti.qasirqu.domain.repository.NewsRepository

class SaveNewsUseCase(private val repository: NewsRepository) {

    suspend fun execute(article: Article){
        repository.saveNews(article)
    }

}