package com.richarddewan.hiltmvvm.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.richarddewan.hiltmvvm.data.local.dao.PersonDao
import com.richarddewan.hiltmvvm.data.local.entity.PersonLocalEntity

@Database(
    entities = [
        PersonLocalEntity::class
    ], version = 1,
    exportSchema = false
)
abstract class DatabaseService : RoomDatabase(){

    abstract fun personDao(): PersonDao

}