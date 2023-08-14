package com.arimukti.textrecognitionapp.data.model

import androidx.room.Entity
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity(tableName = "data")
data class LoginData(
    @SerializedName("id")
    val id: Int,
    @SerializedName("username")
    val username: String,
    @SerializedName("email")
    val email: String?,
    @SerializedName("phone_number")
    val phoneNumber: String?,
    @SerializedName("is_admin")
    val isAdmin: Boolean,
    @SerializedName("accessToken")
    val accessToken: String,
) : Serializable