package com.app.apppractice.data.network

import androidx.room.*
import com.app.apppractice.data.model.ShoppingCart
import kotlinx.coroutines.flow.Flow

@Dao
interface ShoppingCartDAO {
    @Query("SELECT * FROM shoppingcart_table")
    fun getAllShoppingCart(): Flow<List<ShoppingCart>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(shoppingCart: ShoppingCart)

    @Query("UPDATE shoppingcart_table SET quantity = :quantity WHERE id = :id")
    suspend fun update(id: Int, quantity: Int)

    @Delete
    suspend fun delete(shoppingCart: ShoppingCart)

    @Query("DELETE FROM shoppingcart_table")
    suspend fun deleteAll()

    @Query("SELECT SUM(price * quantity) FROM shoppingcart_table")
    suspend fun totalBuy(): Double
}