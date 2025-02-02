package com.example.massproject_test.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.massproject_test.common.Converters
import com.example.massproject_test.data.local.dao.MassDao
import com.example.massproject_test.data.local.model.CharacterEntity


@Database(
    entities = [
        CharacterEntity::class
    ],
    version = 1
)
@TypeConverters(Converters::class)
abstract class MassDatabase : RoomDatabase() {
    abstract val dao: MassDao
}