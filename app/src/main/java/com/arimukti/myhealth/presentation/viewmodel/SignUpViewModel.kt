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
import com.arimukti.myhealth.data.model.SignUpResponse
import com.arimukti.myhealth.data.util.Resource
import com.arimukti.myhealth.domain.usecase.SignUpUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SignUpViewModel(
    private val app: Application,
    private val signUpUseCase: SignUpUseCase
) : AndroidViewModel(app) {

    private val _signUpResponse = MutableLiveData<Resource<SignUpResponse>>()
    val signUpResponse: LiveData<Resource<SignUpResponse>> by lazy { _signUpResponse }

    fun signUp(username: String, email: String, password: String, phoneNumber: Int = 0) {
        viewModelScope.launch(Dispatchers.IO) {
            _signUpResponse.postValue(Resource.Loading())
            try {
                if (isNetworkAvailable(app)) {
                    val apiResult = signUpUseCase.invoke(username, email, password, phoneNumber)
                    _signUpResponse.postValue(apiResult)
                } else {
                    _signUpResponse.postValue(Resource.Error(message = "Internet not available"))
                }
            } catch (e: Exception) {
                _signUpResponse.postValue(Resource.Error(e.message.toString()))
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
}