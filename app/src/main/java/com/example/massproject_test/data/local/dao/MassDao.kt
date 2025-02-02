package com.example.massproject_test.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.massproject_test.data.local.model.CharacterEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MassDao {
    @Query("SELECT * FROM character")
    suspend fun getCharacter(): CharacterEntity?

    @Query("SELECT * FROM character")
    fun observeCharacter(): Flow<CharacterEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCharacter(character: CharacterEntity)
}