package com.example.mealsapp

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface IngredientDao {
    @Query("Select * from ingredients")
    suspend fun getAll(): List<Ingredients>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertIngredients(vararg ingredients: Ingredients)

    @Insert
    suspend fun insertAll(vararg ingredients: Ingredients)

    @Query("Select mealName from Ingredients where Ingredient1 LIKE '%' || :searchTerm || '%' OR Ingredient2 LIKE '%' || :searchTerm || '%' OR Ingredient3 LIKE '%' || :searchTerm || '%'OR Ingredient4 LIKE '%' || :searchTerm || '%'OR Ingredient5 LIKE '%' || :searchTerm || '%'OR Ingredient6 LIKE '%' || :searchTerm || '%'OR Ingredient7 LIKE '%' || :searchTerm || '%'OR Ingredient8 LIKE '%' || :searchTerm || '%'OR Ingredient9 LIKE '%' || :searchTerm || '%'OR Ingredient10 LIKE '%' || :searchTerm || '%'OR Ingredient11 LIKE '%' || :searchTerm || '%'OR Ingredient12 LIKE '%' || :searchTerm || '%'OR Ingredient13 LIKE '%' || :searchTerm || '%'OR Ingredient14 LIKE '%' || :searchTerm || '%'OR Ingredient15 LIKE '%' || :searchTerm || '%'OR Ingredient16 LIKE '%' || :searchTerm || '%'OR Ingredient17 LIKE '%' || :searchTerm || '%'OR Ingredient18 LIKE '%' || :searchTerm || '%'OR Ingredient19 LIKE '%' || :searchTerm || '%'OR Ingredient20 LIKE '%' || :searchTerm || '%'")
    suspend fun searchIngredient(searchTerm: String): List<String>

    @Query("Select * from Ingredients where mealName = :searchTerm ")
    suspend fun searchingredb(searchTerm: String): List<Ingredients>
}