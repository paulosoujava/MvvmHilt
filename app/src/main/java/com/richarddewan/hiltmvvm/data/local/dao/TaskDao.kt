package com.richarddewan.hiltmvvm.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.richarddewan.hiltmvvm.data.local.entity.TaskLocalEntity


@Dao
interface PersonDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(task: TaskLocalEntity): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMany(persons: List<TaskLocalEntity>): List<Long>

    @Query("SELECT * FROM persons")
    suspend fun getPersons(): List<TaskLocalEntity>
}