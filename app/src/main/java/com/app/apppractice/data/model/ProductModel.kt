package com.app.apppractice.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

 class ProductModel: Serializable {
     var id: Int = 0
     lateinit var title: String
     var price: Double = 0.0
     lateinit var category: String
     lateinit var description: String
     lateinit var image: String
}