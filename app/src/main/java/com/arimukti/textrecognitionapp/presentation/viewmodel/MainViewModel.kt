package com.arimukti.textrecognitionapp.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.arimukti.textrecognitionapp.utils.Ext.calc
import com.arimukti.textrecognitionapp.utils.Ext.default

class MainViewModel(
    app: Application
) : AndroidViewModel(app) {
    private val _a = MutableLiveData<String>().default("0 + 0")
    val a: LiveData<String> by lazy { _a }

    private val _c = MutableLiveData<Int>().default(0)
    val c: LiveData<Int> by lazy { _c }

    fun calculate(text: String) {
        calc(text).let {
            if (it.first.isNotBlank() || it.first.isNotEmpty()) {
                _a.value = it.first
                _c.value = it.second
            }
        }
    }
}