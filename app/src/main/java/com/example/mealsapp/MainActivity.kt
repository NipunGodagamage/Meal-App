package com.example.mealsapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.room.Room
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class
MainActivity : AppCompatActivity() {

    private val API_URL = "https://www.themealdb.com/api/json/v1/1/filter.php?i="

    private lateinit var Button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Button = findViewById(R.id.addMealstoDbBtn)
        Button.setOnClickListener {
            addMealtoDb()
            showAlert()

        }

        Button = findViewById(R.id.SearchforMealsByIngredientbtn)
        Button.setOnClickListener {
            val intent = Intent(this, SearchMealByIngredients::class.java)
            startActivity(intent)

        }

        Button = findViewById(R.id.searchForMealbtn)
        Button.setOnClickListener {
            val intent = Intent(this, SearchForMeal::class.java)
            startActivity(intent)

        }
        Button = findViewById(R.id.searchForMealNamebtn)
        Button.setOnClickListener {
            val intent = Intent(this, SearchMealByName::class.java)
            startActivity(intent)
        }
    }
    fun addMealtoDb(){
        // create the database
        val db = Room.databaseBuilder(this, MappDatabase::class.java,
            "mydatabase").build()
        val MealsDao = db.MealsDao()
        val IngredientDao = db.IngredientDao()
        val MeasureDao = db.MeasureDao()

        runBlocking {
            launch {
                val meal1 = Meals(1,"Sweet and Sour Pork","null",
                    "Pork","Chinese","https:\\/\\/www.themealdb.com\\/images\\/media\\/meals\\/1529442316.jpg",
                    "Sweet", "Preparation\\r\\n1. Crack the egg into a bowl. Separate the egg white and yolk.\\r\\n\\r\\nSweet and Sour Pork\\r\\n2. Slice the pork tenderloin into ips.\\r\\n\\r\\n3. Prepare the marinade using a pinch of salt, one teaspoon of starch, two teaspoons of light soy sauce, and an egg white.\\r\\n\\r\\n4. Marinade the pork ips for about 20 minutes.\\r\\n\\r\\n5. Put the remaining starch in a bowl. Add some water and vinegar to make a starchy sauce.\\r\\n\\r\\nSweet and Sour Pork\\r\\nCooking Inuctions\\r\\n1. Pour the cooking oil into a wok and heat to 190\\u00b0C (375\\u00b0F). Add the marinated pork ips and fry them until they turn brown. Remove the cooked pork from the wok and place on a plate.\\r\\n\\r\\n2. Leave some oil in the wok. Put the tomato sauce and white sugar into the wok, and heat until the oil and sauce are fully combined.\\r\\n\\r\\n3. Add some water to the wok and thoroughly heat the sweet and sour sauce before adding the pork ips to it.\\r\\n\\r\\n4. Pour in the starchy sauce. Stir-fry all the ingredients until the pork and sauce are thoroughly mixed together.\\r\\n\\r\\n5. Serve on a plate and add some coriander for decoration.",
                    "https:\\/\\/www.youtube.com\\/watch?v=mdaBIhgEAMo", "null","null","null","null")

                val meal2 = Meals(2,"Chicken Marengo","null",
                    "Chicken","French","https:\\/\\/www.themealdb.com\\/images\\/media\\/meals\\/qpxvuq1511798906.jpg",
                    "null", "Heat the oil in a large flameproof casserole dish and stir-fry the mushrooms until they start to soften. Add the chicken legs and cook briefly on each side to colour them a little.\\r\\nPour in the passata, crumble in the stock cube and stir in the olives. Season with black pepper \\u2013 you shouldn\\u2019t need salt. Cover and simmer for 40 mins until the chicken is tender. Sprinkle with parsley and serve with pasta and a salad, or mash and green veg, if you like.",
                    "https:\\/\\/www.youtube.com\\/watch?v=U33HYUr-0Fw", "https:\\/\\/www.bbcgoodfood.com\\/recipes\\/3146682\\/chicken-marengo","null","null","null")

                val meal3 = Meals(3,"Beef Banh Mi Bowls with Sriracha Mayo, Carrot & Pickled Cucumber","null",
                    "Beef","Vietnamese","https:\\/\\/www.themealdb.com\\/images\\/media\\/meals\\/z0ageb1583189517.jpg",
                    "null", "Add'l ingredients: mayonnaise, siracha\\r\\n\\r\\n1\\r\\n\\r\\nPlace rice in a fine-mesh sieve and rinse until water runs clear. Add to a small pot with 1 cup water (2 cups for 4 servings) and a pinch of salt. Bring to a boil, then cover and reduce heat to low. Cook until rice is tender, 15 minutes. Keep covered off heat for at least 10 minutes or until ready to serve.\\r\\n\\r\\n2\\r\\n\\r\\nMeanwhile, wash and dry all produce. Peel and finely chop garlic. Zest and quarter lime (for 4 servings, zest 1 lime and quarter both). Trim and halve cucumber lengthwise; thinly slice crosswise into half-moons. Halve, peel, and medium dice onion. Trim, peel, and grate carrot.\\r\\n\\r\\n3\\r\\n\\r\\nIn a medium bowl, combine cucumber, juice from half the lime, \\u00bc tsp sugar (\\u00bd tsp for 4 servings), and a pinch of salt. In a small bowl, combine mayonnaise, a pinch of garlic, a squeeze of lime juice, and as much sriracha as you\\u2019d like. Season with salt and pepper.\\r\\n\\r\\n4\\r\\n\\r\\nHeat a drizzle of oil in a large pan over medium-high heat. Add onion and cook, stirring, until softened, 4-5 minutes. Add beef, remaining garlic, and 2 tsp sugar (4 tsp for 4 servings). Cook, breaking up meat into pieces, until beef is browned and cooked through, 4-5 minutes. Stir in soy sauce. Turn off heat; taste and season with salt and pepper.\\r\\n\\r\\n5\\r\\n\\r\\nFluff rice with a fork; stir in lime zest and 1 TBSP butter. Divide rice between bowls. Arrange beef, grated carrot, and pickled cucumber on top. Top with a squeeze of lime juice. Drizzle with sriracha mayo.",
                    "", "null","null","null","null")

                val meal4 = Meals(4,"Leblebi Soup","null",
                    "Vegetarian","Tunisian","https:\\/\\/www.themealdb.com\\/images\\/media\\/meals\\/x2fw9e1560460636.jpg",
                    "Soup", "Heat the oil in a large pot. Add the onion and cook until translucent.\\r\\nDrain the soaked chickpeas and add them to the pot together with the vegetable stock. Bring to the boil, then reduce the heat and cover. Simmer for 30 minutes.\\r\\nIn the meantime toast the cumin in a small ungreased frying pan, then grind them in a mortar. Add the garlic and salt and pound to a fine paste.\\r\\nAdd the paste and the harissa to the soup and simmer until the chickpeas are tender, about 30 minutes.\\r\\nSeason to taste with salt, pepper and lemon juice and serve hot.",
                    "https:\\/\\/www.youtube.com\\/watch?v=BgRifcCwinY", "http:\\/\\/allrecipes.co.uk\\/recipe\\/43419\\/leblebi--tunisian-chickpea-soup-.aspx","null","null","null")

                MealsDao.insertMeals(meal1,meal2,meal3,meal4)
                //val meals: List<Meals> = MealsDao.getAll()
            }
        }

        runBlocking {
            launch {
                val meal01ingredients = Ingredients("Sweet and Sour Pork","Pork","Egg","Water","Salt","Sugar","Soy Sauce","Starch","Tomato Puree","Vinegar","Coriander",
                    "null","null","null","null","null","null","null","null","null","null")

                val meal02ingredients = Ingredients("Chicken Marengo","Olive Oil","Mushrooms","Chicken Legs","Passata","Chicken Stock Cube","Black Olives","Parsley","null","null","null",
                    "null","null","null","null","null","null","null","null","null","null")

                val meal03ingredients = Ingredients("Beef Banh Mi Bowls with Sriracha Mayo, Carrot & Pickled Cucumber","Rice","Onion","Lime","Garlic Clove","Cucumber","Carrots","Ground Beef","Soy Sauce","null","null",
                    "null","null","null","null","null","null","null","null","null","null")

                val meal04ingredients = Ingredients("Leblebi Soup","Olive Oil","Onion","Chickpeas","Vegetable Stock","Cumin","Garlic","Salt","Harissa Spice","Pepper","Lime",
                    "null","null","null","null","null","null","null","null","null","null")

                IngredientDao.insertIngredients(meal01ingredients,meal02ingredients,meal03ingredients,meal04ingredients)

            }
        }

        runBlocking {
            launch {
                val meal01measure = Measures("Sweet and Sour Pork","200g","1","Dash","1\\/2 tsp","1 tsp ","10g","10g","30g","10g","Dash",
                    "null","null","null","null","null","null","null","null","null","null")

                val meal02measure = Measures("Chicken Marengo","1 tbs","300g","4","500g","1 ","100g","Chopped","null","null","null",
                    "null","null","null","null","null","null","null","null","null","null")

                val meal03measure = Measures("Beef Banh Mi Bowls with Sriracha Mayo, Carrot & Pickled Cucumber","White","1","1","3","1 ","3 oz","1 lb","2 oz","null","null",
                    "null","null","null","null","null","null","null","null","null","null")

                val meal04measure = Measures("Leblebi Soup","2 tbs","1 medium finely diced","250g","1.5L","1 tsp ","5 cloves","1\\/2 tsp","1 tsp ","Pinch","1\\/2",
                    "null","null","null","null","null","null","null","null","null","null")

                MeasureDao.insertMeasures(meal01measure,meal02measure,meal03measure,meal04measure)
                // val measures:List<Measures> = MeasureDao.getAll()
            }
        }

    }
    private fun showAlert() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Done")
        builder.setMessage("Data Save to the DB ")
        builder.setPositiveButton("OK", null)
        val dialog = builder.create()
        dialog.show()
    }

}


