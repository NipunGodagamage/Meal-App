package com.example.mealsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import org.json.JSONArray
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class SearchMealByName : AppCompatActivity() {

    private lateinit var searchBymealName: Button
    private lateinit var searchBymealNameTextView: TextView
    private lateinit var searchBymealNameEdittext: EditText

    var allMeals2 : ArrayList<Meals> = arrayListOf()
    var allIngredients2 : ArrayList<Ingredients> = arrayListOf()
    var allMeasures2 : ArrayList<Measures> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_meal_by_name)

        searchBymealNameTextView = findViewById(R.id.textView21)

        searchBymealNameEdittext = findViewById(R.id.editTextTextMealName3)


        searchBymealName = findViewById(R.id.button21)
        searchBymealName.setOnClickListener {

           getMealbyMealName()
        }

    }

    var allMealapi = java.lang.StringBuilder()

    private fun getMealbyMealName(){
        val EditTextValue = searchBymealNameEdittext.text.toString()
        val stb = StringBuilder()
        val url_string = "https://www.themealdb.com/api/json/v1/1/search.php?s=$EditTextValue"
        val url = URL(url_string)
        val con : HttpURLConnection = url.openConnection() as HttpURLConnection

        runBlocking {
            launch {
                withContext(Dispatchers.IO){
                    val bf = BufferedReader(InputStreamReader(con.inputStream))
                    var line: String? = bf.readLine()
                    while (line != null){
                        stb.append(line + "\n")
                        line = bf.readLine()
                    }
                    parseJSONapi(stb)
                }
            }
            searchBymealNameTextView .setText(allMealapi)
            allMealapi.clear()
        }
    }

    private fun parseJSONapi(stb: java.lang.StringBuilder){

        val json = JSONObject(stb.toString())
        val jsonArray: JSONArray = json.getJSONArray("meals")
        for (i in 0.. jsonArray.length()-1){

            val meal = jsonArray.getJSONObject(i)

            val mealId = meal.getInt("idMeal")
            val mealName = meal.getString("strMeal")
            val drink = meal.getString("strDrinkAlternate")
            val category = meal.getString("strCategory")
            val area = meal.getString("strArea")
            val instruction = meal.getString("strInstructions")
            val mealThumb = meal.getString("strMealThumb")
            val tags = meal.getString("strTags")
            val youtube = meal.getString("strYoutube")
            val source = meal.getString("strSource")
            val imgSource = meal.getString("strImageSource")
            val creativeCommons = meal.getString("strCreativeCommonsConfirmed")
            val dateModified = meal.getString("dateModified")

            val ingredient1 = meal.getString("strIngredient1")
            val ingredient2 = meal.getString("strIngredient2")
            val ingredient3 = meal.getString("strIngredient3")
            val ingredient4 = meal.getString("strIngredient4")
            val ingredient5 = meal.getString("strIngredient5")
            val ingredient6 = meal.getString("strIngredient6")
            val ingredient7 = meal.getString("strIngredient7")
            val ingredient8 = meal.getString("strIngredient8")
            val ingredient9 = meal.getString("strIngredient9")
            val ingredient10 = meal.getString("strIngredient10")
            val ingredient11 = meal.getString("strIngredient11")
            val ingredient12 = meal.getString("strIngredient12")
            val ingredient13 = meal.getString("strIngredient13")
            val ingredient14 = meal.getString("strIngredient14")
            val ingredient15 = meal.getString("strIngredient15")
            val ingredient16 = meal.getString("strIngredient16")
            val ingredient17 = meal.getString("strIngredient17")
            val ingredient18 = meal.getString("strIngredient18")
            val ingredient19 = meal.getString("strIngredient19")
            val ingredient20 = meal.getString("strIngredient20")

            val measure1 = meal.getString("strMeasure1")
            val measure2 = meal.getString("strMeasure2")
            val measure3 = meal.getString("strMeasure3")
            val measure4 = meal.getString("strMeasure4")
            val measure5 = meal.getString("strMeasure5")
            val measure6 = meal.getString("strMeasure6")
            val measure7 = meal.getString("strMeasure7")
            val measure8 = meal.getString("strMeasure8")
            val measure9 = meal.getString("strMeasure9")
            val measure10 = meal.getString("strMeasure10")
            val measure11 = meal.getString("strMeasure11")
            val measure12 = meal.getString("strMeasure12")
            val measure13 = meal.getString("strMeasure13")
            val measure14 = meal.getString("strMeasure14")
            val measure15 = meal.getString("strMeasure15")
            val measure16 = meal.getString("strMeasure16")
            val measure17 = meal.getString("strMeasure17")
            val measure18 = meal.getString("strMeasure18")
            val measure19 = meal.getString("strMeasure19")
            val measure20 = meal.getString("strMeasure20")


            val meals = Meals(mealId,mealName,drink,category,area,instruction,mealThumb,tags,youtube,
                source,imgSource,creativeCommons,dateModified)
            allMeals2.add(meals)

            val ingredients = Ingredients(mealName,ingredient1,ingredient2,ingredient3,ingredient4,ingredient5,ingredient6,ingredient7,
                ingredient8,ingredient9, ingredient10,ingredient11,ingredient12,ingredient13,
                ingredient14,ingredient15,ingredient16,ingredient17,ingredient18,ingredient19,ingredient20)
            allIngredients2.add(ingredients)

            val measures = Measures(mealName,measure1,measure2,measure3,measure4,measure5,measure6,measure7,measure8,measure9,
                measure10,measure11,measure12,measure13,
                measure14,measure15,measure16,measure17,measure18,measure19,measure20)
            allMeasures2.add(measures)


            //allMeal.append("MealID : $mealId \n")
            allMealapi.append("Meal : $mealName \n\n")
            allMealapi.append("DrinkAlternate : $drink \n ")
            allMealapi.append("Category : $category \n")
            allMealapi.append("Area : $area \n\n")
            allMealapi.append("Instruction : $instruction \n\n")
            allMealapi.append("MealThumb : $mealThumb \n")
            allMealapi.append("Tags : $tags \n")
            allMealapi.append("Youtube : $youtube \n\n")
            allMealapi.append("Ingredient1 : $ingredient1 \n")
            allMealapi.append("Ingredient2 : $ingredient2 \n")
            allMealapi.append("Ingredient3 : $ingredient3 \n")
            allMealapi.append("Ingredient4 : $ingredient4 \n")
            allMealapi.append("Ingredient5 : $ingredient5 \n")
            allMealapi.append("Ingredient6 : $ingredient6 \n")
            allMealapi.append("Ingredient7 : $ingredient7 \n")
            allMealapi.append("Ingredient8 : $ingredient8 \n")
            allMealapi.append("Ingredient9 : $ingredient9 \n")
            allMealapi.append("Ingredient10 : $ingredient10 \n")
            allMealapi.append("Ingredient11 : $ingredient11 \n")
            allMealapi.append("Ingredient12 : $ingredient12 \n")
            allMealapi.append("Ingredient13 : $ingredient13 \n")
            allMealapi.append("Ingredient14 : $ingredient14 \n")
            allMealapi.append("Ingredient15 : $ingredient15 \n")
            allMealapi.append("Ingredient16 : $ingredient16 \n")
            allMealapi.append("Ingredient17 : $ingredient17 \n")
            allMealapi.append("Ingredient18 : $ingredient18 \n")
            allMealapi.append("Ingredient19 : $ingredient19 \n")
            allMealapi.append("Ingredient20 : $ingredient20 \n\n")
            allMealapi.append("Measure1 : $measure1 \n" )
            allMealapi.append("Measure2 : $measure2 \n" )
            allMealapi.append("Measure3 : $measure3 \n" )
            allMealapi.append("Measure4 : $measure4 \n" )
            allMealapi.append("Measure5 : $measure5 \n" )
            allMealapi.append("Measure6 : $measure6 \n" )
            allMealapi.append("Measure7 : $measure7 \n" )
            allMealapi.append("Measure8 : $measure8 \n" )
            allMealapi.append("Measure9 : $measure9 \n" )
            allMealapi.append("Measure10 : $measure10 \n" )
            allMealapi.append("Measure11 : $measure11 \n" )
            allMealapi.append("Measure12 : $measure12 \n" )
            allMealapi.append("Measure13 : $measure13 \n" )
            allMealapi.append("Measure14 : $measure14 \n" )
            allMealapi.append("Measure15 : $measure15 \n" )
            allMealapi.append("Measure16 : $measure16 \n" )
            allMealapi.append("Measure17 : $measure17 \n" )
            allMealapi.append("Measure18 : $measure18 \n" )
            allMealapi.append("Measure19 : $measure19 \n" )
            allMealapi.append("Measure20 : $measure20 \n\n" )
            allMealapi.append("Source : $source \n")
            allMealapi.append("ImgSource : $imgSource \n")
            allMealapi.append("CreativeCommons : $creativeCommons \n")
            allMealapi.append("DateModified : $dateModified \n\n\n")
            allMealapi.append("-------------------------------------------\n\n")
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putSerializable("allMeals", allMeals2)
        outState.putSerializable("allIngredients", allIngredients2)
        outState.putSerializable("allMeasures", allMeasures2)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle){
        super.onRestoreInstanceState(savedInstanceState)
        allMeals2 = savedInstanceState.getSerializable("allMeals2") as ArrayList<Meals>
        allIngredients2 = savedInstanceState.getSerializable("allIngredients2") as ArrayList<Ingredients>
        allMeasures2 = savedInstanceState.getSerializable("allMeasures2") as ArrayList<Measures>

        for (i in 0 until allMeals2.size){

            allMealapi.append("Meal : ${allMeals2[i].mealName}\n\n")
            allMealapi.append("Meal : ${allMeals2[i].DrinkAlternate}\n\n")
            allMealapi.append("Meal : ${allMeals2[i].mealCategory}\n\n")
            allMealapi.append("Meal : ${allMeals2[i].mealArea}\n\n")
            allMealapi.append("Meal : ${allMeals2[i].mealInst}\n\n")
            allMealapi.append("Meal : ${allMeals2[i].MealThumb}\n\n")
            allMealapi.append("Meal : ${allMeals2[i].mealTags}\n\n")
            allMealapi.append("Meal : ${allMeals2[i].Youtube}\n\n")

            allMealapi.append("Ingredient1 : ${allIngredients2[i].Ingredient1}\n")
            allMealapi.append("Ingredient1 : ${allIngredients2[i].Ingredient2}\n")
            allMealapi.append("Ingredient1 : ${allIngredients2[i].Ingredient3}\n")
            allMealapi.append("Ingredient1 : ${allIngredients2[i].Ingredient4}\n")
            allMealapi.append("Ingredient1 : ${allIngredients2[i].Ingredient5}\n")
            allMealapi.append("Ingredient1 : ${allIngredients2[i].Ingredient6}\n")
            allMealapi.append("Ingredient1 : ${allIngredients2[i].Ingredient7}\n")
            allMealapi.append("Ingredient1 : ${allIngredients2[i].Ingredient8}\n")
            allMealapi.append("Ingredient1 : ${allIngredients2[i].Ingredient9}\n")
            allMealapi.append("Ingredient1 : ${allIngredients2[i].Ingredient10}\n")
            allMealapi.append("Ingredient1 : ${allIngredients2[i].Ingredient11}\n")
            allMealapi.append("Ingredient1 : ${allIngredients2[i].Ingredient12}\n")
            allMealapi.append("Ingredient1 : ${allIngredients2[i].Ingredient13}\n")
            allMealapi.append("Ingredient1 : ${allIngredients2[i].Ingredient14}\n")
            allMealapi.append("Ingredient1 : ${allIngredients2[i].Ingredient15}\n")
            allMealapi.append("Ingredient1 : ${allIngredients2[i].Ingredient16}\n")
            allMealapi.append("Ingredient1 : ${allIngredients2[i].Ingredient17}\n")
            allMealapi.append("Ingredient1 : ${allIngredients2[i].Ingredient18}\n")
            allMealapi.append("Ingredient1 : ${allIngredients2[i].Ingredient19}\n")
            allMealapi.append("Ingredient1 : ${allIngredients2[i].Ingredient20}\n")

            allMealapi.append("Measure1 : ${allMeasures2[i].Measure1}\n")
            allMealapi.append("Measure1 : ${allMeasures2[i].Measure2}\n")
            allMealapi.append("Measure1 : ${allMeasures2[i].Measure3}\n")
            allMealapi.append("Measure1 : ${allMeasures2[i].Measure4}\n")
            allMealapi.append("Measure1 : ${allMeasures2[i].Measure5}\n")
            allMealapi.append("Measure1 : ${allMeasures2[i].Measure6}\n")
            allMealapi.append("Measure1 : ${allMeasures2[i].Measure7}\n")
            allMealapi.append("Measure1 : ${allMeasures2[i].Measure8}\n")
            allMealapi.append("Measure1 : ${allMeasures2[i].Measure9}\n")
            allMealapi.append("Measure1 : ${allMeasures2[i].Measure10}\n")
            allMealapi.append("Measure1 : ${allMeasures2[i].Measure11}\n")
            allMealapi.append("Measure1 : ${allMeasures2[i].Measure12}\n")
            allMealapi.append("Measure1 : ${allMeasures2[i].Measure13}\n")
            allMealapi.append("Measure1 : ${allMeasures2[i].Measure14}\n")
            allMealapi.append("Measure1 : ${allMeasures2[i].Measure15}\n")
            allMealapi.append("Measure1 : ${allMeasures2[i].Measure16}\n")
            allMealapi.append("Measure1 : ${allMeasures2[i].Measure17}\n")
            allMealapi.append("Measure1 : ${allMeasures2[i].Measure18}\n")
            allMealapi.append("Measure1 : ${allMeasures2[i].Measure19}\n")
            allMealapi.append("Measure1 : ${allMeasures2[i].Measure20}\n")
            allMealapi.append("Meal : ${allMeals2[i].Source}\n\n")
            allMealapi.append("Meal : ${allMeals2[i].ImageSource}\n\n")
            allMealapi.append("Meal : ${allMeals2[i].CreativeCommonsConfirmed}\n\n")
            allMealapi.append("Meal : ${allMeals2[i].dateModified}\n\n")
            allMealapi.append("-------------------------------------------\n\n")

        }

    }


}