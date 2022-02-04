package com.app.apppractice.ui.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.apppractice.R
import com.app.apppractice.data.model.ShoppingCart
import com.bumptech.glide.Glide

class ShoppingCartAdapter(val shoppingCartListener: ShoppingCartListener) :
    RecyclerView.Adapter<ShoppingCartViewHolder>() {

    var listItems = listOf<ShoppingCart>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingCartViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ShoppingCartViewHolder(
            layoutInflater.inflate(
                R.layout.item_shopping_cart,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ShoppingCartViewHolder, position: Int) {
        val item = listItems[position]
        holder.tvProductName.text = item.title
        holder.tvProductPrice.text = item.price.toString()
        Glide.with(holder.itemView.context)
            .load(item.image)
            .into(holder.ivProductImage)
        holder.tvProductQuantity.text = item.quantity.toString()
        holder.ibRemove.setOnClickListener {
            shoppingCartListener.onRemoveItemClicked(item, position)
        }
        holder.ibAddQuantity.setOnClickListener {
            shoppingCartListener.onUpdateQuantityClicked(item, position, 1)
        }
        holder.ibRemoveQuantity.setOnClickListener {
            shoppingCartListener.onUpdateQuantityClicked(item, position, -1)
        }
    }

    override fun getItemCount() = listItems.size
}