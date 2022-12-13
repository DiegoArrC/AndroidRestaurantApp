package com.example.restaurantapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var itemCount : TextView
    private lateinit var itemPrice : TextView
    private lateinit var itemName : TextView
    private var itemCountint = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonSubtract = findViewById<Button>(R.id.subtract)
        val buttonIncrease = findViewById<Button>(R.id.add)
        val checkout = findViewById<Button>(R.id.checkout)

        itemCount = findViewById(R.id.etitemCount)
        itemPrice = findViewById(R.id.itemPrice)
        itemName = findViewById(R.id.itemName)
        buttonSubtract.setOnClickListener {
            decreaseCount()
        }
        buttonIncrease.setOnClickListener {
            increaseCount()
        }
        checkout.setOnClickListener {
            val intent = Intent(this, RestaurantCheckout::class.java)
            intent.putExtra("quantity",itemCount.text)
            intent.putExtra("price",itemPrice.text)
            intent.putExtra("name",itemName.text)
            startActivity(intent)
        }
    }


    private fun decreaseCount(){
        if (itemCountint > 0) {
            itemCountint --
            itemCount.text = itemCountint.toString()
        }
        else{
            Toast.makeText(this,"Cannot go below 0",Toast.LENGTH_LONG).show()
        }
    }
    private fun increaseCount() {
        itemCountint ++
        itemCount.text = itemCountint.toString()
    }
}