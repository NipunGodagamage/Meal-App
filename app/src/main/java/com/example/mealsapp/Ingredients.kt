package com.example.mealsapp

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Ingredients(
    @PrimaryKey val mealName: String,
    val Ingredient1 : String?,
    val Ingredient2 : String?,
    val Ingredient3 : String?,
    val Ingredient4 : String?,
    val Ingredient5 : String?,
    val Ingredient6 : String?,
    val Ingredient7 : String?,
    val Ingredient8 : String?,
    val Ingredient9 : String?,
    val Ingredient10 : String?,
    val Ingredient11 : String?,
    val Ingredient12 : String?,
    val Ingredient13 : String?,
    val Ingredient14 : String?,
    val Ingredient15 : String?,
    val Ingredient16 : String?,
    val Ingredient17 : String?,
    val Ingredient18 : String?,
    val Ingredient19 : String?,
    val Ingredient20: String?,
)
