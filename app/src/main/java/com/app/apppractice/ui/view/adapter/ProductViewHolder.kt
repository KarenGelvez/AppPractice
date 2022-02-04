package com.app.apppractice.ui.view.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.app.apppractice.R
import com.app.apppractice.databinding.ItemProductBinding
import com.squareup.picasso.Picasso

class ProductViewHolder(view: View): RecyclerView.ViewHolder(view) {

    private val binding = ItemProductBinding.bind(view)

    val ivProductImage = binding.ivItemProductImage
    val tvProductName = binding.tvItemProductName
    val tvProductCategory = binding.tvItemCategoryName
    val ibProductFavorite = binding.ibFavorite

}