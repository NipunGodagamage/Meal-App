package com.example.mealsapp

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [Meals::class,Ingredients::class,Measures::class], version=1)

abstract class MappDatabase: RoomDatabase() {
    abstract fun MealsDao(): MealsDao
    abstract fun IngredientDao():IngredientDao
    abstract fun MeasureDao(): MeasureDao

}