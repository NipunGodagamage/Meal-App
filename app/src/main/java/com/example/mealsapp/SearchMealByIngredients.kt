package com.example.mealsapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.room.Room
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

class SearchMealByIngredients : AppCompatActivity() {

    private lateinit var retrieveMealsButton: Button
    private lateinit var saveApimealsDBbutton:Button
    private lateinit var mealDetailsTextView: TextView
    private lateinit var searchEdittext: EditText


    var mealID : ArrayList<Int> = arrayListOf()
    var allMeals : ArrayList<Meals> = arrayListOf()
    var allIngredients : ArrayList<Ingredients> = arrayListOf()
    var allMeasures : ArrayList<Measures> = arrayListOf()




    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_search_meal_by_ingredients)

        mealDetailsTextView = findViewById(R.id.textView1)

        searchEdittext = findViewById(R.id.editTextTextMealName)


        retrieveMealsButton = findViewById(R.id.buttonapi)
        retrieveMealsButton.setOnClickListener {

            getIDbyIngredient()
     }
        saveApimealsDBbutton = findViewById(R.id.button3)
        saveApimealsDBbutton.setOnClickListener {

            saveAlldataToDb()
            showAlert()
        }
  }

    var allMeal = java.lang.StringBuilder()

    private fun getIDbyIngredient(){
        val editTextValue = searchEdittext.text.toString()
        val stb = StringBuilder()
        val url_string = "https://www.themealdb.com/api/json/v1/1/filter.php?i=$editTextValue"
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
                    parseJSON(stb)
                }
            }
            mealDetailsTextView.setText(allMeal)
            allMeal.clear()
        }
    }

    private fun parseJSON(stb: java.lang.StringBuilder){
        val json = JSONObject(stb.toString())
        if (!json.isNull("meals")){
            val jsonArray: JSONArray = json.getJSONArray("meals")
            for(i in 0.. jsonArray.length() -1){
                val meal = jsonArray.getJSONObject(i)
                val id = meal.getInt("idMeal")
                mealID.add(id)
                getFullMeal(id)
            }
        }
    }

    private fun getFullMeal(id:Int){
        val stb = StringBuilder()
        val url_string = "https://www.themealdb.com/api/json/v1/1/lookup.php?i=$id"
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
                    parseJSON1(stb)
                }
            }
        }
    }

    private fun parseJSON1(stb: java.lang.StringBuilder){

        val json = JSONObject(stb.toString())
        val jsonArray:JSONArray = json.getJSONArray("meals")
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
            allMeals.add(meals)

            val ingredients = Ingredients(mealName,ingredient1,ingredient2,ingredient3,ingredient4,ingredient5,ingredient6,ingredient7,
                ingredient8,ingredient9, ingredient10,ingredient11,ingredient12,ingredient13,
                ingredient14,ingredient15,ingredient16,ingredient17,ingredient18,ingredient19,ingredient20)
            allIngredients.add(ingredients)

            val measures = Measures(mealName,measure1,measure2,measure3,measure4,measure5,measure6,measure7,measure8,measure9,
                measure10,measure11,measure12,measure13,
                measure14,measure15,measure16,measure17,measure18,measure19,measure20)
            allMeasures.add(measures)


            //allMeal.append("MealID : $mealId \n")
            allMeal.append("Meal : $mealName \n\n")
            allMeal.append("DrinkAlternate : $drink \n ")
            allMeal.append("Category : $category \n")
            allMeal.append("Area : $area \n\n")
            allMeal.append("Instruction : $instruction \n\n")
            allMeal.append("MealThumb : $mealThumb \n")
            allMeal.append("Tags : $tags \n")
            allMeal.append("Youtube : $youtube \n\n")
            allMeal.append("Ingredient1 : $ingredient1 \n")
            allMeal.append("Ingredient2 : $ingredient2 \n")
            allMeal.append("Ingredient3 : $ingredient3 \n")
            allMeal.append("Ingredient4 : $ingredient4 \n")
            allMeal.append("Ingredient5 : $ingredient5 \n")
            allMeal.append("Ingredient6 : $ingredient6 \n")
            allMeal.append("Ingredient7 : $ingredient7 \n")
            allMeal.append("Ingredient8 : $ingredient8 \n")
            allMeal.append("Ingredient9 : $ingredient9 \n")
            allMeal.append("Ingredient10 : $ingredient10 \n")
            allMeal.append("Ingredient11 : $ingredient11 \n")
            allMeal.append("Ingredient12 : $ingredient12 \n")
            allMeal.append("Ingredient13 : $ingredient13 \n")
            allMeal.append("Ingredient14 : $ingredient14 \n")
            allMeal.append("Ingredient15 : $ingredient15 \n")
            allMeal.append("Ingredient16 : $ingredient16 \n")
            allMeal.append("Ingredient17 : $ingredient17 \n")
            allMeal.append("Ingredient18 : $ingredient18 \n")
            allMeal.append("Ingredient19 : $ingredient19 \n")
            allMeal.append("Ingredient20 : $ingredient20 \n\n")
            allMeal.append("Measure1 : $measure1 \n" )
            allMeal.append("Measure2 : $measure2 \n" )
            allMeal.append("Measure3 : $measure3 \n" )
            allMeal.append("Measure4 : $measure4 \n" )
            allMeal.append("Measure5 : $measure5 \n" )
            allMeal.append("Measure6 : $measure6 \n" )
            allMeal.append("Measure7 : $measure7 \n" )
            allMeal.append("Measure8 : $measure8 \n" )
            allMeal.append("Measure9 : $measure9 \n" )
            allMeal.append("Measure10 : $measure10 \n" )
            allMeal.append("Measure11 : $measure11 \n" )
            allMeal.append("Measure12 : $measure12 \n" )
            allMeal.append("Measure13 : $measure13 \n" )
            allMeal.append("Measure14 : $measure14 \n" )
            allMeal.append("Measure15 : $measure15 \n" )
            allMeal.append("Measure16 : $measure16 \n" )
            allMeal.append("Measure17 : $measure17 \n" )
            allMeal.append("Measure18 : $measure18 \n" )
            allMeal.append("Measure19 : $measure19 \n" )
            allMeal.append("Measure20 : $measure20 \n\n" )
            allMeal.append("Source : $source \n")
            allMeal.append("ImgSource : $imgSource \n")
            allMeal.append("CreativeCommons : $creativeCommons \n")
            allMeal.append("DateModified : $dateModified \n\n\n")
            allMeal.append("-------------------------------------------\n\n")
        }

    }

   private fun saveAlldataToDb(){

       val db = Room.databaseBuilder(this, MappDatabase::class.java,
           "mydatabase").build()
       val MealsDao = db.MealsDao()
       val IngredientDao = db.IngredientDao()
       val MeasureDao = db.MeasureDao()

       runBlocking {
           launch {
               for (i in 0..allMeals.size-1){
                   MealsDao.insertMeals(allMeals[i])
                   IngredientDao.insertIngredients(allIngredients[i])
                   MeasureDao.insertMeasures(allMeasures[i])
               }
           }
       }
   }
    private fun showAlert() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Done")
        builder.setMessage("Data Save to the DB")
        builder.setPositiveButton("OK", null)
        val dialog = builder.create()
        dialog.show()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putSerializable("mealID", mealID)
        outState.putSerializable("allMeals", allMeals)
        outState.putSerializable("allIngredients", allIngredients)
        outState.putSerializable("allMeasures", allMeasures)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle){
        super.onRestoreInstanceState(savedInstanceState)
        mealID = savedInstanceState.getSerializable("mealID") as ArrayList<Int>
        allMeals = savedInstanceState.getSerializable("allMeals") as ArrayList<Meals>
        allIngredients = savedInstanceState.getSerializable("allIngredients") as ArrayList<Ingredients>
        allMeasures = savedInstanceState.getSerializable("allMeasures") as ArrayList<Measures>

        for (i in 0 until allMeals.size){

            allMeal.append("Meal : ${allMeals[i].mealName}\n\n")
            allMeal.append("Meal : ${allMeals[i].DrinkAlternate}\n\n")
            allMeal.append("Meal : ${allMeals[i].mealCategory}\n\n")
            allMeal.append("Meal : ${allMeals[i].mealArea}\n\n")
            allMeal.append("Meal : ${allMeals[i].mealInst}\n\n")
            allMeal.append("Meal : ${allMeals[i].MealThumb}\n\n")
            allMeal.append("Meal : ${allMeals[i].mealTags}\n\n")
            allMeal.append("Meal : ${allMeals[i].Youtube}\n\n")

            allMeal.append("Ingredient1 : ${allIngredients[i].Ingredient1}\n")
            allMeal.append("Ingredient1 : ${allIngredients[i].Ingredient2}\n")
            allMeal.append("Ingredient1 : ${allIngredients[i].Ingredient3}\n")
            allMeal.append("Ingredient1 : ${allIngredients[i].Ingredient4}\n")
            allMeal.append("Ingredient1 : ${allIngredients[i].Ingredient5}\n")
            allMeal.append("Ingredient1 : ${allIngredients[i].Ingredient6}\n")
            allMeal.append("Ingredient1 : ${allIngredients[i].Ingredient7}\n")
            allMeal.append("Ingredient1 : ${allIngredients[i].Ingredient8}\n")
            allMeal.append("Ingredient1 : ${allIngredients[i].Ingredient9}\n")
            allMeal.append("Ingredient1 : ${allIngredients[i].Ingredient10}\n")
            allMeal.append("Ingredient1 : ${allIngredients[i].Ingredient11}\n")
            allMeal.append("Ingredient1 : ${allIngredients[i].Ingredient12}\n")
            allMeal.append("Ingredient1 : ${allIngredients[i].Ingredient13}\n")
            allMeal.append("Ingredient1 : ${allIngredients[i].Ingredient14}\n")
            allMeal.append("Ingredient1 : ${allIngredients[i].Ingredient15}\n")
            allMeal.append("Ingredient1 : ${allIngredients[i].Ingredient16}\n")
            allMeal.append("Ingredient1 : ${allIngredients[i].Ingredient17}\n")
            allMeal.append("Ingredient1 : ${allIngredients[i].Ingredient18}\n")
            allMeal.append("Ingredient1 : ${allIngredients[i].Ingredient19}\n")
            allMeal.append("Ingredient1 : ${allIngredients[i].Ingredient20}\n")

            allMeal.append("Measure1 : ${allMeasures[i].Measure1}\n")
            allMeal.append("Measure1 : ${allMeasures[i].Measure2}\n")
            allMeal.append("Measure1 : ${allMeasures[i].Measure3}\n")
            allMeal.append("Measure1 : ${allMeasures[i].Measure4}\n")
            allMeal.append("Measure1 : ${allMeasures[i].Measure5}\n")
            allMeal.append("Measure1 : ${allMeasures[i].Measure6}\n")
            allMeal.append("Measure1 : ${allMeasures[i].Measure7}\n")
            allMeal.append("Measure1 : ${allMeasures[i].Measure8}\n")
            allMeal.append("Measure1 : ${allMeasures[i].Measure9}\n")
            allMeal.append("Measure1 : ${allMeasures[i].Measure10}\n")
            allMeal.append("Measure1 : ${allMeasures[i].Measure11}\n")
            allMeal.append("Measure1 : ${allMeasures[i].Measure12}\n")
            allMeal.append("Measure1 : ${allMeasures[i].Measure13}\n")
            allMeal.append("Measure1 : ${allMeasures[i].Measure14}\n")
            allMeal.append("Measure1 : ${allMeasures[i].Measure15}\n")
            allMeal.append("Measure1 : ${allMeasures[i].Measure16}\n")
            allMeal.append("Measure1 : ${allMeasures[i].Measure17}\n")
            allMeal.append("Measure1 : ${allMeasures[i].Measure18}\n")
            allMeal.append("Measure1 : ${allMeasures[i].Measure19}\n")
            allMeal.append("Measure1 : ${allMeasures[i].Measure20}\n")
            allMeal.append("Meal : ${allMeals[i].Source}\n\n")
            allMeal.append("Meal : ${allMeals[i].ImageSource}\n\n")
            allMeal.append("Meal : ${allMeals[i].CreativeCommonsConfirmed}\n\n")
            allMeal.append("Meal : ${allMeals[i].dateModified}\n\n")
            allMeal.append("-------------------------------------------\n\n")

    }


    }


}