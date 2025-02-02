package com.example.massproject_test.common

import com.example.massproject_test.data.local.model.CharacterEntity
import com.example.massproject_test.data.local.model.InfoEntity
import com.example.massproject_test.data.local.model.LocationEntity
import com.example.massproject_test.data.local.model.OriginEntity
import com.example.massproject_test.data.local.model.ResultEntity
import com.example.massproject_test.data.network.model.CharacterDto
import com.example.massproject_test.data.network.model.InfoDto
import com.example.massproject_test.data.network.model.LocationDto
import com.example.massproject_test.data.network.model.OriginDto
import com.example.massproject_test.data.network.model.ResultDto
import com.example.massproject_test.domain.model.Character
import com.example.massproject_test.domain.model.Info
import com.example.massproject_test.domain.model.Location
import com.example.massproject_test.domain.model.Origin
import com.example.massproject_test.domain.model.Result

fun CharacterEntity.toCharacter(): Character {
    return Character(
        results = results.map { it.toResult() },
        info = info.toInfo(),
    )
}

fun InfoEntity.toInfo(): Info {
    return Info(
        count = count,
        pages = pages,
        next = next,
        prev = prev
    )
}

fun ResultEntity.toResult(): Result {
    return Result(
        id = id,
        name = name,
        status = status,
        species = species,
        type = type,
        gender = gender,
        origin = origin.toOrigin(),
        location = location.toLocation(),
        image = image,
        episode = episode,
        url = url,
        created = created
    )
}

fun OriginEntity.toOrigin(): Origin {
    return Origin(
        name = name,
        url = url
    )
}

fun LocationEntity.toLocation(): Location {
    return Location(
        name = name,
        url = url
    )
}

fun CharacterDto.toCharacterEntity(): CharacterEntity {
    return CharacterEntity(
        info = info.toInfoEntity(),
        results = results.map { it.toResultEntity() }
    )
}

fun InfoDto.toInfoEntity(): InfoEntity {
    return InfoEntity(
        count = count,
        pages = pages,
        next = next,
        prev = prev
    )
}

fun ResultDto.toResultEntity(): ResultEntity {
    return ResultEntity(
        id = id,
        name = name,
        status = status,
        species = species,
        type = type,
        gender = gender,
        origin = origin.toOriginEntity(),
        location = location.toLocationEntity(),
        image = image,
        episode = episode,
        url = url,
        created = created
    )
}

fun OriginDto.toOriginEntity(): OriginEntity {
    return OriginEntity(
        name = name,
        url = url
    )
}

fun LocationDto.toLocationEntity(): LocationEntity {
    return LocationEntity(
        name = name,
        url = url
    )
}

fun CharacterDto.toCharacter(): Character {
    return Character(
        results = results.map { it.toResult() },
        info = info.toInfo()
    )
}

fun InfoDto.toInfo(): Info {
    return Info(
        count = count,
        pages = pages,
        next = next,
        prev = prev
    )
}

fun ResultDto.toResult(): Result {
    return Result(
        id = id,
        name = name,
        status = status,
        species = species,
        type = type,
        gender = gender,
        origin = origin.toOrigin(),
        location = location.toLocation(),
        image = image,
        episode = episode,
        url = url,
        created = created
    )
}

fun OriginDto.toOrigin(): Origin {
    return Origin(
        name = name,
        url = url
    )
}

fun LocationDto.toLocation(): Location {
    return Location(
        name = name,
        url = url
    )
}

