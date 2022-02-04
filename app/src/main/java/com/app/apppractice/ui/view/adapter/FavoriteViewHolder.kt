package com.app.apppractice.ui.view.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.app.apppractice.databinding.FragmentFavoriteBinding
import com.app.apppractice.databinding.ItemProductBinding

class FavoriteViewHolder(view: View): RecyclerView.ViewHolder(view)  {

    private val binding = ItemProductBinding.bind(view)

    val ivProductImage = binding.ivItemProductImage
    val tvProductName = binding.tvItemProductName
    val tvProductCategory = binding.tvItemCategoryName
    val ibProductFavorite = binding.ibFavorite

}