package com.app.apppractice.data

import com.app.apppractice.data.model.Favorite
import com.app.apppractice.data.model.ShoppingCart
import com.app.apppractice.data.network.FavoriteDAO
import com.app.apppractice.data.network.ShoppingCartDAO
import kotlinx.coroutines.flow.Flow

class ShoppingCartRepository(private val shoppingCartDAO: ShoppingCartDAO) {
    val allShoppingCart: Flow<List<ShoppingCart>> = shoppingCartDAO.getAllShoppingCart()

    suspend fun insert(shoppingCart: ShoppingCart) {
        shoppingCartDAO.insert(shoppingCart)
    }

    suspend fun update(id: Int, quantity: Int) {
        shoppingCartDAO.update(id, quantity)
    }

    suspend fun delete(shoppingCart: ShoppingCart) {
        shoppingCartDAO.delete(shoppingCart)
    }

    suspend fun deleteAll() {
        shoppingCartDAO.deleteAll()
    }

    suspend fun totalBuy(): Double {
        return shoppingCartDAO.totalBuy()
    }

}