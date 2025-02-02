package com.example.massproject_test.domain.repository

import com.example.massproject_test.common.RequestResult
import com.example.massproject_test.domain.model.Character
import kotlinx.coroutines.flow.Flow

interface HomeRepository {
    suspend fun getAllCharacters(): Flow<RequestResult<Character>>
}