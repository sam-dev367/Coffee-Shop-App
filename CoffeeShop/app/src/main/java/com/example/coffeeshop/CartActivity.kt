package com.example.coffeeshop

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.coffeeshop.databinding.ActivityCartBinding

class CartActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvCart.layoutManager = LinearLayoutManager(this)
        binding.rvCart.adapter = CartAdapter(Cart.items) { refresh() }

        binding.btnCheckout.setOnClickListener {
            if (Cart.items.isEmpty()) return@setOnClickListener
            Toast.makeText(this, "Order placed! Thank you", Toast.LENGTH_LONG).show()
            Cart.items.clear()
            finish()
        }
        binding.btnBack.setOnClickListener { finish() }
        refresh()
    }

    private fun refresh() {
        binding.tvTotal.text = "Total: ₹%.0f".format(Cart.total())
        binding.tvEmpty.visibility = if (Cart.items.isEmpty()) View.VISIBLE else View.GONE
    }
}
