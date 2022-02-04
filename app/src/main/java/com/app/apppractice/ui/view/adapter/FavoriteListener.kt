package com.app.apppractice.ui.view.adapter

import com.app.apppractice.data.model.Favorite
import com.app.apppractice.data.model.ProductModel

interface FavoriteListener {
    fun onFavoriteClicked(favorite: Favorite, position: Int)
}