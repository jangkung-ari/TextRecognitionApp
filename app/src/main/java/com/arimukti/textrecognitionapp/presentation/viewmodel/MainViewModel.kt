package com.arimukti.textrecognitionapp.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.arimukti.textrecognitionapp.utils.Ext.default

class MainViewModel(
    private val app: Application
) : AndroidViewModel(app) {
    private val _a = MutableLiveData<Int>().default(0)
    val a: LiveData<Int> by lazy { _a }

    private val _b = MutableLiveData<Int>().default(0)
    val b: LiveData<Int> by lazy { _b }

    private val _c = MutableLiveData<Int>().default(0)
    val c: LiveData<Int> by lazy { _c }
}