package com.example.massproject_test.data.repository

import com.example.massproject_test.common.RequestResponseMergeStrategy
import com.example.massproject_test.common.RequestResult
import com.example.massproject_test.common.map
import com.example.massproject_test.common.toCharacter
import com.example.massproject_test.common.toCharacterEntity
import com.example.massproject_test.common.toRequestResult
import com.example.massproject_test.data.local.dao.MassDao
import com.example.massproject_test.data.local.model.CharacterEntity
import com.example.massproject_test.data.network.MassApi
import com.example.massproject_test.data.network.model.CharacterDto
import com.example.massproject_test.domain.model.Character
import com.example.massproject_test.domain.repository.HomeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.merge
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val api: MassApi,
    private val dao: MassDao,
): HomeRepository {

    override suspend fun getAllCharacters(): Flow<RequestResult<Character>> {
        val mergeStrategy = RequestResponseMergeStrategy<Character>()
        val cache: Flow<RequestResult<Character>> = getAllFromCache()
        val network: Flow<RequestResult<Character>> = getAllFromNetwork()

        return cache.combine(network, mergeStrategy::merge)
            .flatMapLatest { result ->
                if (result is RequestResult.Success) {
                    dao.observeCharacter()
                        .map { it.toCharacter() }
                        .map {RequestResult.Success(it) }
                } else {
                    flowOf(result)
                }
            }
    }

    private fun getAllFromNetwork(): Flow<RequestResult<Character>> {
        val request = flow { emit(api.getCharacters()) }
            .onEach { result ->
                if (result.isSuccessful) result.body()?.let { saveCharactersToCache(it) }
            }
            .map { it.toRequestResult() }

        val start = flowOf<RequestResult<CharacterDto>>(RequestResult.InProgress())
        return merge(request, start)
            .map { result: RequestResult<CharacterDto> ->
                result.map { entity ->
                    entity.toCharacter()
                }
            }
    }

    private suspend fun saveCharactersToCache(data: CharacterDto) {
        val entity = data.toCharacterEntity()
        dao.insertCharacter(entity)
    }

    private suspend fun getAllFromCache(): Flow<RequestResult<Character>> {
        val request = dao.getCharacter()

        val end = if (request != null) {
            flowOf<RequestResult<CharacterEntity>>(RequestResult.Success(request))
        } else {
            flowOf<RequestResult<CharacterEntity>>(RequestResult.Error(error = Throwable("Cache is empty")))
        }
        val start = flowOf<RequestResult<CharacterEntity>>(RequestResult.InProgress())

        return merge(start, end).map { result ->
            result.map { entity -> entity.toCharacter() }
        }
    }
}