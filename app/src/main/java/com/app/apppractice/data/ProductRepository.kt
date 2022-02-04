package com.app.apppractice.data

import com.app.apppractice.data.model.ProductModel
import com.app.apppractice.data.model.ProductProvider
import com.app.apppractice.data.network.ProductService

class ProductRepository {
    private val api = ProductService()
    suspend fun getAllProducts():List<ProductModel>{
        val response = api.getProducts()
        ProductProvider.products = response
        return response
    }
}