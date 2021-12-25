package com.osmanacikgoz.weatherapp.network.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.osmanacikgoz.weatherapp.network.local.entity.SearchItem

@Database(
    entities = [
        SearchItem::class,
    ], version = 1, exportSchema = false
)
abstract class AppDataBase : RoomDatabase() {
    abstract fun searchDao(): SearchDao

}