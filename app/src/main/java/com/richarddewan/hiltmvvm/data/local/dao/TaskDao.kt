package com.richarddewan.hiltmvvm.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.richarddewan.hiltmvvm.data.local.entity.TaskLocalEntity


@Dao
interface TaskDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(task: TaskLocalEntity): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMany(tasks: List<TaskLocalEntity>): List<Long>

    @Query("SELECT * FROM tasks")
    suspend fun getTasks(): List<TaskLocalEntity>


}