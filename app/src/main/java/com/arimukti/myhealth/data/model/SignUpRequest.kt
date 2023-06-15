package com.arimukti.myhealth.data.model

data class SignUpRequest(
    val username: String,
    val email: String,
    val is_admin: Boolean = true,
    val password: String,
    val phone_number: Int
)