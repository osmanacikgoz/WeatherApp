package com.osmanacikgoz.weatherapp.network.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.osmanacikgoz.weatherapp.network.local.entity.SearchItem

@Dao
interface SearchDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSearchItem(searchItem: SearchItem)

    @Query("SELECT * FROM city ORDER BY `createdDate` DESC LIMIT 5")
    fun getAllSearchedCity(): List<SearchItem>

}