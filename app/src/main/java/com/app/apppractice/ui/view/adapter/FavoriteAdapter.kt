package com.app.apppractice.ui.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.apppractice.R
import com.app.apppractice.data.model.Favorite
import com.app.apppractice.data.model.ProductModel
import com.bumptech.glide.Glide

class FavoriteAdapter(val favoriteListener: FavoriteListener) :
    RecyclerView.Adapter<FavoriteViewHolder>() {

    var listFavorite = listOf<Favorite>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return FavoriteViewHolder(layoutInflater.inflate(R.layout.item_product, parent, false))
    }

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
        val favorite = listFavorite[position]
        holder.ibProductFavorite.setImageResource(R.drawable.ic_favorite)
        holder.tvProductName.text = favorite.title
        holder.tvProductCategory.text = favorite.category
        Glide.with(holder.itemView.context)
            .load(favorite.image)
            .into(holder.ivProductImage)
        holder.ibProductFavorite.setOnClickListener {
            favoriteListener.onFavoriteClicked(favorite, position)
        }
    }

    override fun getItemCount() = listFavorite.size

}