package com.example.massproject_test.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "character")
data class CharacterEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    @ColumnInfo(name = "info") val info: InfoEntity,
    @ColumnInfo(name = "results") val results: List<ResultEntity>
)

data class InfoEntity(
    val count: Int,
    val pages: Int,
    val next: String,
    val prev: String?
)

data class LocationEntity(
    val name: String,
    val url: String
)

data class OriginEntity(
    val name: String,
    val url: String
)

data class ResultEntity(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val origin: OriginEntity,
    val location: LocationEntity,
    val image: String,
    val episode: List<String>,
    val url: String,
    val created: String
)