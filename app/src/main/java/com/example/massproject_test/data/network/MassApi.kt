package com.example.massproject_test.data.network

import com.example.massproject_test.data.network.model.CharacterDto
import com.example.massproject_test.data.network.model.ResponseDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MassApi {
    @GET("character")
    suspend fun getCharacters(): Response<CharacterDto>

}