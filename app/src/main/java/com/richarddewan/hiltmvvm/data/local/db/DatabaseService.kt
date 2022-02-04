package com.richarddewan.hiltmvvm.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.richarddewan.hiltmvvm.data.local.dao.TaskDao
import com.richarddewan.hiltmvvm.data.local.entity.TaskLocalEntity

@Database(entities = [TaskLocalEntity::class],version = 1, exportSchema = false)
abstract  class DatabaseService: RoomDatabase() {

    abstract fun taskDao(): TaskDao

}