package com.example.restaurantapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlin.math.roundToInt

class RestaurantCheckout : AppCompatActivity() {
    private lateinit var itemCount : TextView
    private lateinit var subtotal : TextView
    private lateinit var taxPrice : TextView
    private lateinit var checkoutName : TextView
    private lateinit var checkoutBasePrice : TextView
    private lateinit var totalPrice : TextView
    private lateinit var orderConfirm : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkout)

        val backButton = findViewById<Button>(R.id.checkoutBack)
        val orderConfirmation = findViewById<Button>(R.id.orderFood)
        val nItemCount = intent.getStringExtra("quantity")
        val nItemPrice = intent.getStringExtra("price")
        val nItemName = intent.getStringExtra("name")
        orderConfirm = findViewById(R.id.orderFood)
        setTextValues(nItemName.toString(),nItemPrice.toString(),nItemCount.toString())

        backButton.setOnClickListener {
//            val intent = Intent(this, MainActivity::class.java).apply {  }
//            startActivity(intent)
            finish()
        }

        orderConfirmation.setOnClickListener {
            placeOrder()
        }
    }
    private fun setTextValues(itemsName: String,itemPrice: String,countOfItems: String){
        findViewById<TextView>(R.id.checkoutName).apply {
            text = "${itemsName.toString()}"
        }
        findViewById<TextView>(R.id.checkoutBasePrice).apply {
            text = "$${itemPrice.toString()}"
        }
        findViewById<TextView>(R.id.itemCount).apply {
            text = "x${countOfItems.toString()}"
        }
        findViewById<TextView>(R.id.subtotal).apply {
            val subtotalAmount = itemPrice.toFloat() * countOfItems.toFloat()
            text = "$${subtotalAmount.toString()}"
        }
        findViewById<TextView>(R.id.taxPrice).apply {
            val totalTax = (itemPrice.toFloat() * countOfItems.toFloat() * 0.1)
            val totalTaxRounded = String.format("%.2f",totalTax).toDouble()
            text = "$$totalTaxRounded"
        }
        findViewById<TextView>(R.id.totalPrice).apply {
            val finalPrice = (itemPrice.toFloat() * countOfItems.toFloat()) * 0.1 + (itemPrice.toFloat() * countOfItems.toFloat())
            val finalPriceRounded = String.format("%.2f",finalPrice).toDouble()
            text = "$$finalPriceRounded"
        }

    }
    private fun placeOrder(){
        orderConfirm.text = "Order Confirmed"
    }
}