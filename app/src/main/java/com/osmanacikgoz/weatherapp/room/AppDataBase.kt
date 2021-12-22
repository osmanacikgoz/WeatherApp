package com.osmanacikgoz.weatherapp.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.osmanacikgoz.weatherapp.model.entity.SearchItemEntity
import com.osmanacikgoz.weatherapp.model.response.SearchItem

@Database(
    entities = [
        SearchItem::class,
    ], version = 1, exportSchema = false
)
abstract class AppDataBase : RoomDatabase() {
    abstract fun searchDao(): SearchDao

}