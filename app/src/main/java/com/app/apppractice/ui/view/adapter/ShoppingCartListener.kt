package com.app.apppractice.ui.view.adapter

import com.app.apppractice.data.model.ShoppingCart

interface ShoppingCartListener {

    fun onRemoveItemClicked(shoppingCart: ShoppingCart, position: Int)

    fun onUpdateQuantityClicked(shoppingCart: ShoppingCart, position: Int, value: Int)
}