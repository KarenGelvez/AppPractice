package com.app.apppractice.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.app.apppractice.data.ShoppingCartRepository
import com.app.apppractice.data.model.ShoppingCart
import kotlinx.coroutines.launch

class ShoppingCartViewModel(private val repository: ShoppingCartRepository) : ViewModel() {
    val allItems: LiveData<List<ShoppingCart>> = repository.allShoppingCart.asLiveData()

    fun insert(shoppingCart: ShoppingCart) = viewModelScope.launch {
        repository.insert(shoppingCart)
    }

    fun update(id: Int, quantity: Int) = viewModelScope.launch {
        repository.update(id, quantity)
    }

    fun delete(shoppingCart: ShoppingCart) = viewModelScope.launch {
        repository.delete(shoppingCart)
    }

    fun deleteAll() = viewModelScope.launch {
        repository.deleteAll()
    }

    fun totalBuy() = viewModelScope.launch {
        repository.totalBuy()
    }
}