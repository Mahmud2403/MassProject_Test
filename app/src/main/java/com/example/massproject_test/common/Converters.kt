package com.example.massproject_test.common

import androidx.room.TypeConverter
import com.example.massproject_test.data.local.model.InfoEntity
import com.example.massproject_test.data.local.model.ResultEntity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converters {
    private val gson = Gson()

    @TypeConverter
    fun fromInfoEntity(info: InfoEntity): String {
        return gson.toJson(info)
    }

    @TypeConverter
    fun toInfoEntity(json: String): InfoEntity {
        return gson.fromJson(json, InfoEntity::class.java)
    }

    @TypeConverter
    fun fromResultEntityList(results: List<ResultEntity>): String {
        return gson.toJson(results)
    }

    @TypeConverter
    fun toResultEntityList(json: String): List<ResultEntity> {
        val type = object : TypeToken<List<ResultEntity>>() {}.type
        return gson.fromJson(json, type)
    }
}
