package com.arimukti.qasirqu.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.arimukti.qasirqu.domain.usecase.GetNewsHeadlineUseCase
import com.arimukti.qasirqu.domain.usecase.GetSaveNewsUseCase
import com.arimukti.qasirqu.domain.usecase.GetSearchedNewsUseCase
import com.arimukti.qasirqu.domain.usecase.SaveNewsUseCase
import com.arimukti.qasirqu.domain.usecase.DeleteSaveNewsUseCase

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
            app, getNewsHeadlineUseCase,getSearchedNewsUseCase,saveNewsUseCase,getSaveNewsUseCase,deleteSaveNewsUseCase
        ) as T
    }
}