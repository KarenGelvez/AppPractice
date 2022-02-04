package com.app.apppractice.ui.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.app.apppractice.R
import androidx.recyclerview.widget.RecyclerView
import com.app.apppractice.data.model.Favorite
import com.app.apppractice.data.model.ProductModel
import com.app.apppractice.databinding.ItemProductBinding
import com.app.apppractice.ui.view.ui.fragments.ProductsFragment
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ProductAdapter(val productsListener: ProductListener) :
    RecyclerView.Adapter<ProductViewHolder>() {

    var listProduct = ArrayList<ProductModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ProductViewHolder(layoutInflater.inflate(R.layout.item_product, parent, false))
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = listProduct[position]
        holder.tvProductName.text = product.title
        holder.tvProductCategory.text = product.category
        Glide.with(holder.itemView.context)
            .load(product.image)
            .into(holder.ivProductImage)

        holder.ibProductFavorite.setOnClickListener {
            val favorite = Favorite(
                id = position + 1,
                title = product.title,
                description = product.description,
                category = product.category,
                price = product.price,
                image = product.image
            )
            productsListener.onFavoriteClicked(favorite, position)
            holder.ibProductFavorite.setImageResource(R.drawable.ic_favorite)
        }

        holder.itemView.setOnClickListener {
            productsListener.onProductClicked(product, position)
        }
    }

    override fun getItemCount() = listProduct.size

    fun updateData(data: List<ProductModel>) {
        listProduct.clear()
        listProduct.addAll(data)
        notifyDataSetChanged()
    }
}