package com.richarddewan.hiltmvvm.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.richarddewan.hiltmvvm.data.local.entity.PersonLocalEntity


@Dao
interface PersonDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(person: PersonLocalEntity): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMany(persons: List<PersonLocalEntity>): List<Long>

    @Query("SELECT * FROM persons")
    suspend fun getPersons(): List<PersonLocalEntity>
}