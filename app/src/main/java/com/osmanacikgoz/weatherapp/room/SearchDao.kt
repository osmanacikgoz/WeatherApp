package com.osmanacikgoz.weatherapp.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.osmanacikgoz.weatherapp.model.entity.SearchItemEntity

@Dao
interface SearchDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSearchCity(searchCity: SearchItemEntity)

    @Query("SELECT * FROM city")
    fun getAllCity(): List<SearchItemEntity>

    @Query("SELECT * FROM city WHERE `key` = :key")
    fun getCityByKey(key: String): SearchItemEntity

}