package com.app.apppractice.data.network

import com.app.apppractice.data.model.ProductModel
import retrofit2.Response
import retrofit2.http.GET

interface ProductApiClient {
    @GET("/products")
    suspend fun getAllProducts(): Response<List<ProductModel>>
}