package com.example.coffeeshop

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.coffeeshop.databinding.ItemProductBinding

class ProductAdapter(
    private var items: List<Product>,
    private val onClick: (Product) -> Unit
) : RecyclerView.Adapter<ProductAdapter.VH>() {

    inner class VH(val b: ItemProductBinding) : RecyclerView.ViewHolder(b.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH =
        VH(ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: VH, position: Int) {
        val p = items[position]
        holder.b.tvName.text = p.name
        holder.b.tvCategory.text = p.category
        holder.b.tvPrice.text = "₹%.0f".format(p.price)
        holder.b.ivProduct.setImageResource(p.imageRes)
        holder.b.root.setOnClickListener { onClick(p) }
    }

    override fun getItemCount() = items.size

    fun update(newItems: List<Product>) {
        items = newItems
        notifyDataSetChanged()
    }
}
