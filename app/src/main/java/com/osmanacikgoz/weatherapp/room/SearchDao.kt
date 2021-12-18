package com.osmanacikgoz.weatherapp.room

import androidx.room.*
import com.osmanacikgoz.weatherapp.model.entity.SearchItemEntity

@Dao
interface SearchDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSearchCity(searchCity: List<SearchItemEntity>)

    @Query("SELECT*FROM SearchItemEntity")
    fun getSearchCits(): List<SearchItemEntity>

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateCity(searchCity: SearchItemEntity)

    @Query("SELECT * FROM SearchItemEntity WHERE localizedName = :name_")
    fun getSpaceStation(name_: String): SearchItemEntity?

    @Query("SELECT * FROM SearchItemEntity WHERE isCurrentCity = '1'")
    fun getCurrentSpaceStation(): SearchItemEntity?

    @Query("SELECT*FROM SearchItemEntity WHERE addCity='1'")
    fun getAddCity(): List<SearchItemEntity>

}