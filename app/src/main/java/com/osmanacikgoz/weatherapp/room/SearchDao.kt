package com.osmanacikgoz.weatherapp.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.osmanacikgoz.weatherapp.model.entity.SearchItemEntity
import com.osmanacikgoz.weatherapp.model.response.SearchItem

@Dao
interface SearchDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSearchCity(searchCity: SearchItem)

    @Query("SELECT * FROM city")
    fun getAllSearchedCity(): LiveData<List<SearchItem>>

    @Query("SELECT * FROM city WHERE `key` = :key")
    fun getCityByKey(key: String): SearchItemEntity

    @Query("DELETE FROM city WHERE rowid = 1")
    suspend fun deleteFirstCity()
}