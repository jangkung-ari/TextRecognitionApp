package com.arimukti.myhealth.data.model

import com.google.gson.annotations.SerializedName

data class SignUpResponse(
    @SerializedName("data")
    val data: SignUpData,
)