package com.osmanacikgoz.weatherapp.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.osmanacikgoz.weatherapp.model.entity.SearchItemEntity

@Database(
    entities = [
        SearchItemEntity::class,
    ], version = 1, exportSchema = false
)
abstract class AppDataBase : RoomDatabase() {
    abstract fun searchDao(): SearchDao
}