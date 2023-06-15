package com.arimukti.myhealth.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.arimukti.myhealth.domain.usecase.GetNewsHeadlineUseCase
import com.arimukti.myhealth.domain.usecase.GetSaveNewsUseCase
import com.arimukti.myhealth.domain.usecase.GetSearchedNewsUseCase
import com.arimukti.myhealth.domain.usecase.SaveNewsUseCase
import com.arimukti.myhealth.domain.usecase.DeleteSaveNewsUseCase

class NewsViewModelFactory(
    private val app: Application,
    private val getNewsHeadlineUseCase: GetNewsHeadlineUseCase,
    private val getSearchedNewsUseCase: GetSearchedNewsUseCase,
    private val saveNewsUseCase: SaveNewsUseCase,
    private val getSaveNewsUseCase: GetSaveNewsUseCase,
    private val deleteSaveNewsUseCase: DeleteSaveNewsUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return NewsViewModel(
            app,
            getNewsHeadlineUseCase,
            getSearchedNewsUseCase,
            saveNewsUseCase,
            getSaveNewsUseCase,
            deleteSaveNewsUseCase
        ) as T
    }
}