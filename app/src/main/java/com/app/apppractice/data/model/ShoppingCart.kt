package com.app.apppractice.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "shoppingcart_table")
data class ShoppingCart(
    @PrimaryKey()
    val id: Int = 0,
    @ColumnInfo
    val title: String,
    @ColumnInfo
    val price: Double = 0.0,
    @ColumnInfo
    val category: String,
    @ColumnInfo
    val description: String,
    @ColumnInfo
    val image: String,
    @ColumnInfo
    val quantity: Int = 1
)
