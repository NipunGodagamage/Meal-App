package com.example.mealsapp


import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Meals(
    @PrimaryKey val id: Int,
    val mealName: String?,
    val DrinkAlternate: String?,
    val mealCategory: String?,
    val mealArea: String?,
    val MealThumb: String?,
    val mealTags: String?,
    val mealInst: String?,
    val Youtube: String?,
    val Source: String?,
    val ImageSource: String?,
    val CreativeCommonsConfirmed: String?,
    val dateModified: String?,

)


