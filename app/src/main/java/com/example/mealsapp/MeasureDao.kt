package com.example.mealsapp

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MeasureDao {
    @Query("Select * from measures")
    suspend fun getAll(): List<Measures>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMeasures(vararg measures: Measures )

    @Insert
    suspend fun insertAll(vararg measures: Measures)

    @Query("Select * from Measures where mealName = :searchTerm ")
    suspend fun searchmeasuredb(searchTerm: String): List<Measures>

}