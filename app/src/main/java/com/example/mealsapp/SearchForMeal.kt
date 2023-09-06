package com.example.mealsapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.room.Room
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class SearchForMeal : AppCompatActivity() {


    private lateinit var searchTextDB: EditText
    private lateinit var searchButtonDB: Button
    private lateinit var searchResultsViewDB: TextView

    var mealNames : ArrayList<String> = arrayListOf()
    var allMeals3 : ArrayList<Meals> = arrayListOf()
    var allIngredients3 : ArrayList<Ingredients> = arrayListOf()
    var allMeasures3 : ArrayList<Measures> = arrayListOf()





    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_for_meal)

        searchResultsViewDB = findViewById(R.id.textView2)

        searchTextDB = findViewById(R.id.editTextTextMealName2)


        searchButtonDB = findViewById(R.id.button2)
        searchButtonDB.setOnClickListener {
            getMealsfromDB()

        }
    }
    var allMealDB = java.lang.StringBuilder()
    private fun getMealsfromDB(){
        val dbediteText = searchTextDB.text.toString().trim()
       // val stb = StringBuilder()
        val db = Room.databaseBuilder(this, MappDatabase::class.java,
            "mydatabase").build()
        val MealsDao = db.MealsDao()
        val IngredientDao = db.IngredientDao()
        //val MeasureDao = db.MeasureDao()

        runBlocking {
            launch {
                val getMeal = MealsDao.searchmeal("%$dbediteText%")
                for (i in 0..getMeal.size-1){
                    mealNames.add(getMeal[i])
                    println(getMeal[i])

                }
                val getMealbyIngre = IngredientDao.searchIngredient("%$dbediteText%")
                for (i in 0.. getMealbyIngre.size-1) {
                    if(getMealbyIngre[i] !in mealNames) {
                        mealNames.add(getMealbyIngre[i])
                        println(getMealbyIngre[i])
                    }
                }
                displaymealsbyDB()
            }
            searchResultsViewDB.setText(allMealDB)
            allMealDB.clear()
        }

        }

    private fun displaymealsbyDB() {
        val db = Room.databaseBuilder(this, MappDatabase::class.java,
            "mydatabase").build()
        val MealsDao = db.MealsDao()
        val IngredientDao = db.IngredientDao()
        val MeasureDao = db.MeasureDao()
        runBlocking {
            launch {
                println(mealNames.size)
                for (i in 0 until mealNames.size) {
                    val mdb = MealsDao.searchmealdb(mealNames[i])
                    val idb = IngredientDao.searchingredb(mealNames[i])
                    val medb = MeasureDao.searchmeasuredb(mealNames[i])
                    allMealDB.append("MealID : ${mdb[0].id}\n")
                    allMealDB.append("Meal : ${mdb[0].mealName} \n")
                    allMealDB.append("DrinkAlternate : : ${mdb[0].DrinkAlternate} \n")
                    allMealDB.append("Category : ${mdb[0].mealCategory} \n")
                    allMealDB.append("Area : ${mdb[0].mealArea} \n")
                    allMealDB.append("Instructions : ${mdb[0].mealInst} \n")
                    allMealDB.append("MealThumb : ${mdb[0].MealThumb} \n")
                    allMealDB.append("Tags : ${mdb[0].mealTags} \n")
                    allMealDB.append("Youtube : ${mdb[0].Youtube} \n\n")
                    allMealDB.append("Ingredient1 : ${idb[0].Ingredient1}\n")
                    allMealDB.append("Ingredient2 : ${idb[0].Ingredient2}\n")
                    allMealDB.append("Ingredient3 : ${idb[0].Ingredient3}\n")
                    allMealDB.append("Ingredient4 : ${idb[0].Ingredient4}\n")
                    allMealDB.append("Ingredient5 : ${idb[0].Ingredient5}\n")
                    allMealDB.append("Ingredient6 : ${idb[0].Ingredient6}\n")
                    allMealDB.append("Ingredient7 : ${idb[0].Ingredient7}\n")
                    allMealDB.append("Ingredient8 : ${idb[0].Ingredient8}\n")
                    allMealDB.append("Ingredient9 : ${idb[0].Ingredient9}\n")
                    allMealDB.append("Ingredient10 : ${idb[0].Ingredient10}\n")
                    allMealDB.append("Ingredient11 : ${idb[0].Ingredient11}\n")
                    allMealDB.append("Ingredient12 : ${idb[0].Ingredient12}\n")
                    allMealDB.append("Ingredient13 : ${idb[0].Ingredient13}\n")
                    allMealDB.append("Ingredient14 : ${idb[0].Ingredient14}\n")
                    allMealDB.append("Ingredient15 : ${idb[0].Ingredient15}\n")
                    allMealDB.append("Ingredient16 : ${idb[0].Ingredient16}\n")
                    allMealDB.append("Ingredient17 : ${idb[0].Ingredient17}\n")
                    allMealDB.append("Ingredient18 : ${idb[0].Ingredient18}\n")
                    allMealDB.append("Ingredient19 : ${idb[0].Ingredient19}\n")
                    allMealDB.append("Ingredient20 : ${idb[0].Ingredient20}\n\n")
                    allMealDB.append("Measure1 : ${medb[0].Measure1}\n")
                    allMealDB.append("Measure2 : ${medb[0].Measure2}\n")
                    allMealDB.append("Measure3 : ${medb[0].Measure3}\n")
                    allMealDB.append("Measure4 : ${medb[0].Measure4}\n")
                    allMealDB.append("Measure5 : ${medb[0].Measure5}\n")
                    allMealDB.append("Measure6 : ${medb[0].Measure6}\n")
                    allMealDB.append("Measure7 : ${medb[0].Measure7}\n")
                    allMealDB.append("Measure8 : ${medb[0].Measure8}\n")
                    allMealDB.append("Measure9 : ${medb[0].Measure9}\n")
                    allMealDB.append("Measure10 : ${medb[0].Measure10}\n")
                    allMealDB.append("Measure11 : ${medb[0].Measure11}\n")
                    allMealDB.append("Measure12 : ${medb[0].Measure12}\n")
                    allMealDB.append("Measure13 : ${medb[0].Measure13}\n")
                    allMealDB.append("Measure14 : ${medb[0].Measure14}\n")
                    allMealDB.append("Measure15 : ${medb[0].Measure15}\n")
                    allMealDB.append("Measure16 : ${medb[0].Measure16}\n")
                    allMealDB.append("Measure17 : ${medb[0].Measure17}\n")
                    allMealDB.append("Measure18 : ${medb[0].Measure18}\n")
                    allMealDB.append("Measure19 : ${medb[0].Measure19}\n")
                    allMealDB.append("Measure20 : ${medb[0].Measure20}\n\n")
                    allMealDB.append("Source : ${mdb[0].Source}\n")
                    allMealDB.append("ImgSource : ${mdb[0].ImageSource}\n")
                    allMealDB.append("CreativeCommons : ${mdb[0].CreativeCommonsConfirmed}\n")
                    allMealDB.append("DateModified : ${mdb[0].dateModified} \n\n\n")
                    allMealDB.append("-------------------------------------------\n\n")

                    val meals3 = Meals(5,"mealName","drink","category","area","instruction","mealThumb","tags","youtube",
                        "source","imgSource","creativeCommons","dateModified")
                    allMeals3.add(meals3)

                    val ingredients3 = Ingredients("mealName","ingredient1","ingredient2","ingredient3","ingredient4","ingredient5","ingredient6","ingredient7",
                        "ingredient8","ingredient9", "ingredient10","ingredient11","ingredient12","ingredient13",
                        "ingredient14","ingredient15","ingredient16","ingredient17","ingredient18","ingredient19","ingredient20")
                    allIngredients3.add(ingredients3)

                    val measures3 = Measures("mealName","measure1","measure2","measure3","measure4","measure5","measure6","measure7","measure8","measure9",
                        "measure10","measure11","measure12","measure13",
                        "measure14","measure15","measure16","measure17","measure18","measure19","measure20")
                    allMeasures3.add(measures3)

                }
            }
            allMealDB.clear()
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putSerializable("allMeals", allMeals3)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        allMeals3 = savedInstanceState.getSerializable("allMeals") as ArrayList<Meals>

        for (i in 0 until allMeals3.size){

            allMealDB.append("Meal : ${allMeals3[i].mealName}\n\n")
            allMealDB.append("Meal : ${allMeals3[i].DrinkAlternate}\n\n")
            allMealDB.append("Meal : ${allMeals3[i].mealCategory}\n\n")
            allMealDB.append("Meal : ${allMeals3[i].mealArea}\n\n")
            allMealDB.append("Meal : ${allMeals3[i].mealInst}\n\n")
            allMealDB.append("Meal : ${allMeals3[i].MealThumb}\n\n")
            allMealDB.append("Meal : ${allMeals3[i].mealTags}\n\n")
            allMealDB.append("Meal : ${allMeals3[i].Youtube}\n\n")

            allMealDB.append("Ingredient1 : ${allIngredients3[i].Ingredient1}\n")
            allMealDB.append("Ingredient1 : ${allIngredients3[i].Ingredient2}\n")
            allMealDB.append("Ingredient1 : ${allIngredients3[i].Ingredient3}\n")
            allMealDB.append("Ingredient1 : ${allIngredients3[i].Ingredient4}\n")
            allMealDB.append("Ingredient1 : ${allIngredients3[i].Ingredient5}\n")
            allMealDB.append("Ingredient1 : ${allIngredients3[i].Ingredient6}\n")
            allMealDB.append("Ingredient1 : ${allIngredients3[i].Ingredient7}\n")
            allMealDB.append("Ingredient1 : ${allIngredients3[i].Ingredient8}\n")
            allMealDB.append("Ingredient1 : ${allIngredients3[i].Ingredient9}\n")
            allMealDB.append("Ingredient1 : ${allIngredients3[i].Ingredient10}\n")
            allMealDB.append("Ingredient1 : ${allIngredients3[i].Ingredient11}\n")
            allMealDB.append("Ingredient1 : ${allIngredients3[i].Ingredient12}\n")
            allMealDB.append("Ingredient1 : ${allIngredients3[i].Ingredient13}\n")
            allMealDB.append("Ingredient1 : ${allIngredients3[i].Ingredient14}\n")
            allMealDB.append("Ingredient1 : ${allIngredients3[i].Ingredient15}\n")
            allMealDB.append("Ingredient1 : ${allIngredients3[i].Ingredient16}\n")
            allMealDB.append("Ingredient1 : ${allIngredients3[i].Ingredient17}\n")
            allMealDB.append("Ingredient1 : ${allIngredients3[i].Ingredient18}\n")
            allMealDB.append("Ingredient1 : ${allIngredients3[i].Ingredient19}\n")
            allMealDB.append("Ingredient1 : ${allIngredients3[i].Ingredient20}\n")

            allMealDB.append("Measure1 : ${allMeasures3[i].Measure1}\n")
            allMealDB.append("Measure1 : ${allMeasures3[i].Measure2}\n")
            allMealDB.append("Measure1 : ${allMeasures3[i].Measure3}\n")
            allMealDB.append("Measure1 : ${allMeasures3[i].Measure4}\n")
            allMealDB.append("Measure1 : ${allMeasures3[i].Measure5}\n")
            allMealDB.append("Measure1 : ${allMeasures3[i].Measure6}\n")
            allMealDB.append("Measure1 : ${allMeasures3[i].Measure7}\n")
            allMealDB.append("Measure1 : ${allMeasures3[i].Measure8}\n")
            allMealDB.append("Measure1 : ${allMeasures3[i].Measure9}\n")
            allMealDB.append("Measure1 : ${allMeasures3[i].Measure10}\n")
            allMealDB.append("Measure1 : ${allMeasures3[i].Measure11}\n")
            allMealDB.append("Measure1 : ${allMeasures3[i].Measure12}\n")
            allMealDB.append("Measure1 : ${allMeasures3[i].Measure13}\n")
            allMealDB.append("Measure1 : ${allMeasures3[i].Measure14}\n")
            allMealDB.append("Measure1 : ${allMeasures3[i].Measure15}\n")
            allMealDB.append("Measure1 : ${allMeasures3[i].Measure16}\n")
            allMealDB.append("Measure1 : ${allMeasures3[i].Measure17}\n")
            allMealDB.append("Measure1 : ${allMeasures3[i].Measure18}\n")
            allMealDB.append("Measure1 : ${allMeasures3[i].Measure19}\n")
            allMealDB.append("Measure1 : ${allMeasures3[i].Measure20}\n")
            allMealDB.append("Meal : ${allMeals3[i].Source}\n\n")
            allMealDB.append("Meal : ${allMeals3[i].ImageSource}\n\n")
            allMealDB.append("Meal : ${allMeals3[i].CreativeCommonsConfirmed}\n\n")
            allMealDB.append("Meal : ${allMeals3[i].dateModified}\n\n")
            allMealDB.append("-------------------------------------------\n\n")


        }

    }



}

