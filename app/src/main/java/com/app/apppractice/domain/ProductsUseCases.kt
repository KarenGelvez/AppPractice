package com.app.apppractice.domain

import com.app.apppractice.data.ProductRepository
import com.app.apppractice.data.model.ProductModel

class ProductsUseCases {
    private val repository = ProductRepository()
    suspend operator fun invoke(): List<ProductModel>? = repository.getAllProducts()
}