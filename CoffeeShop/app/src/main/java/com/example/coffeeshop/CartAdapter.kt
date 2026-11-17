package com.example.coffeeshop

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.coffeeshop.databinding.ItemCartBinding

class CartAdapter(
    private val items: MutableList<CartItem>,
    private val onRemove: () -> Unit
) : RecyclerView.Adapter<CartAdapter.VH>() {

    inner class VH(val b: ItemCartBinding) : RecyclerView.ViewHolder(b.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH =
        VH(ItemCartBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: VH, position: Int) {
        val item = items[position]
        holder.b.tvName.text = item.product.name
        holder.b.tvInfo.text = "${item.size} × ${item.quantity}"
        holder.b.tvLineTotal.text = "₹%.0f".format(item.lineTotal)
        holder.b.btnRemove.setOnClickListener {
            val pos = holder.bindingAdapterPosition
            if (pos != RecyclerView.NO_POSITION) {
                Cart.remove(items[pos])
                notifyItemRemoved(pos)
                onRemove()
            }
        }
    }

    override fun getItemCount() = items.size
}
