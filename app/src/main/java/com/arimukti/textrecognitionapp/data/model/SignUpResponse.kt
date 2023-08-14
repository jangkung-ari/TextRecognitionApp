package com.arimukti.textrecognitionapp.data.model

import com.google.gson.annotations.SerializedName

data class SignUpResponse(
    @SerializedName("data")
    val data: SignUpData,
)