package com.example.coffeeshop

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.coffeeshop.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var b: ActivityDetailBinding
    private var qty = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(b.root)

        val product = ProductRepository.getById(intent.getIntExtra("id", 1))
        b.ivProduct.setImageResource(product.imageRes)
        b.tvName.text = product.name
        b.tvDesc.text = product.description
        b.tvPrice.text = "₹%.0f".format(product.price)
        b.tvQty.text = qty.toString()

        b.btnPlus.setOnClickListener { qty++; b.tvQty.text = qty.toString() }
        b.btnMinus.setOnClickListener {
            if (qty > 1) { qty--; b.tvQty.text = qty.toString() }
        }

        b.btnAddToCart.setOnClickListener {
            val size = when (b.rgSize.checkedRadioButtonId) {
                R.id.rbS -> "Small"
                R.id.rbL -> "Large"
                else -> "Medium"
            }
            Cart.add(product, qty, size)
            Toast.makeText(this, "Added to cart", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}
