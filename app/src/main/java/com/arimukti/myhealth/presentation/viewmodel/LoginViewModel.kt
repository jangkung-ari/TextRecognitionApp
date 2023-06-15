package com.arimukti.myhealth.presentation.viewmodel

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.arimukti.myhealth.data.model.LoginResponse
import com.arimukti.myhealth.data.util.Resource
import com.arimukti.myhealth.domain.usecase.LoginUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginViewModel(
    private val app: Application,
    private val loginUseCase: LoginUseCase
) : AndroidViewModel(app) {

    private val _loginResponse = MutableLiveData<Resource<LoginResponse>>()
    val loginResponse: LiveData<Resource<LoginResponse>> by lazy { _loginResponse }

    fun login(username: String, password: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _loginResponse.postValue(Resource.Loading())
            try {
                if (isNetworkAvailable(app)) {
                    val apiResult = loginUseCase.invoke(username, password)
                    _loginResponse.postValue(apiResult)
                } else {
                    _loginResponse.postValue(Resource.Error(message = "Internet not available"))
                }
            } catch (e: Exception) {
                _loginResponse.postValue(Resource.Error(e.message.toString()))
            }
        }
    }

    private fun isNetworkAvailable(context: Context?): Boolean {
        if (context == null) return false
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            val capabilities =
                connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
            if (capabilities != null) {
                when {
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> {
                        return true
                    }
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> {
                        return true
                    }
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> {
                        return true
                    }
                }
            }
        }
        return true//todo check this shit
    }

//    fun saveToken(article: Article) = viewModelScope.launch {
//        saveNewsUseCase.execute(article)
//    }
}