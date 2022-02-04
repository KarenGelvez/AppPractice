package com.app.apppractice.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.apppractice.data.model.ProductModel
import com.app.apppractice.domain.ProductsUseCases
import kotlinx.coroutines.launch

class ProductViewModel: ViewModel()  {

    val listProduct: MutableLiveData<List<ProductModel>> = MutableLiveData()
    val isLoading = MutableLiveData<Boolean>()
    var productUseCase = ProductsUseCases()

    fun onCreate() {
        viewModelScope.launch {
            val result = productUseCase()
            if(!result.isNullOrEmpty()){
                listProduct.postValue(result)
                isLoading.postValue(false)
            }
        }
    }
}