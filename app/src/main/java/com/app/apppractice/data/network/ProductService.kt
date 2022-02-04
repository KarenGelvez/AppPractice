package com.app.apppractice.data.network

import com.app.apppractice.data.model.ProductModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ProductService {
    private val retrofit = RetrofitHelper.getRetrofitProducts()
    suspend fun getProducts(): List<ProductModel> {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(ProductApiClient::class.java).getAllProducts()
            response.body() ?: emptyList()
        }
    }
}