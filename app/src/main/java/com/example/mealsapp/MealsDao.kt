package com.example.mealsapp

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MealsDao {

    @Query("Select * from meals")
    suspend fun getAll(): List<Meals>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMeals(vararg meals: Meals)

    @Insert
    suspend fun insertAll(vararg meals: Meals)

    @Query("Select mealName from Meals where mealName like :searchTerm")
    suspend fun searchmeal(searchTerm: String): List<String>

    @Query("Select * from Meals where mealName = :searchTerm ")
    suspend fun searchmealdb(searchTerm: String): List<Meals>





}