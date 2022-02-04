package com.app.apppractice.ui.view.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.app.apppractice.databinding.ItemShoppingCartBinding

class ShoppingCartViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemShoppingCartBinding.bind(view)

    val ivProductImage = binding.ivItemProductImage
    val tvProductName = binding.tvItemProductName
    val tvProductPrice = binding.tvItemPrice
    val tvProductQuantity = binding.tvQuantity
    val ibAddQuantity = binding.ibAddQuantity
    val ibRemoveQuantity = binding.ibRemoveQuantity
    val ibRemove = binding.ibRemove
}