package com.example.massproject_test.data.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseDto<E>(
    @SerialName("status") val status: String,
    @SerialName("totalResults") val totalResults: Int,
    @SerialName("character") val character: E
)
