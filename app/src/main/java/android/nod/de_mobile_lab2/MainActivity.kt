package android.nod.de_mobile_lab2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    lateinit var editTextAddFood: EditText
    lateinit var btnAddFood: Button
    lateinit var btnDecide: Button
    lateinit var hamTitle: TextView

    private val foodList = ArrayList<String>()

    var foods = arrayOf(
        "Hamburger", "Pizza",
        "Mexican", "American", "Chinese"
    );

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }

    fun init() {
        btnAddFood = findViewById(R.id.btnAddFood)
        editTextAddFood = findViewById(R.id.editTextAddFood)
        btnDecide = findViewById(R.id.btnDecide)
        hamTitle = findViewById(R.id.hamTitle)

        //add foods in  arrray
        foodList.addAll(foods)

        btnAddFood.setOnClickListener {
            if (!editTextAddFood.text.isNullOrEmpty()) {
                foodList.add(editTextAddFood.text.toString())
                editTextAddFood.text.clear()
            } else {
                Toast.makeText(this, "Enter valid text", Toast.LENGTH_SHORT)
                    .show()

            }
        }
        btnDecide.setOnClickListener {
            val randIn = Random.nextInt(0, foodList.size)
            hamTitle.text = foodList[randIn]
        }
    }

}