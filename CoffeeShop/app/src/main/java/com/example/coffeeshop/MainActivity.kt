package com.example.coffeeshop

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.coffeeshop.databinding.ActivityMainBinding
import com.google.android.material.chip.Chip

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = ProductAdapter(ProductRepository.products) { product ->
            startActivity(
                Intent(this, DetailActivity::class.java).putExtra("id", product.id)
            )
        }
        binding.rvProducts.layoutManager = LinearLayoutManager(this)
        binding.rvProducts.adapter = adapter

        val categories = listOf("All") + ProductRepository.products.map { it.category }.distinct()
        categories.forEach { cat ->
            val chip = Chip(this).apply {
                text = cat
                isCheckable = true
                isChecked = cat == "All"
            }
            chip.setOnClickListener {
                adapter.update(
                    if (cat == "All") ProductRepository.products
                    else ProductRepository.products.filter { it.category == cat }
                )
            }
            binding.chipGroup.addView(chip)
        }

        binding.btnCart.setOnClickListener {
            startActivity(Intent(this, CartActivity::class.java))
        }
    }

    override fun onResume() {
        super.onResume()
        binding.btnCart.text = "View Cart (${Cart.items.sumOf { it.quantity }})"
    }
}
