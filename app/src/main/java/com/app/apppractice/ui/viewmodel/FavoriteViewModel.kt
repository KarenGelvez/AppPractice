package com.app.apppractice.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.app.apppractice.data.FavoriteRepository
import com.app.apppractice.data.model.Favorite
import kotlinx.coroutines.launch

class FavoriteViewModel(private val repository: FavoriteRepository) : ViewModel() {
    val allFavorites: LiveData<List<Favorite>> = repository.allFavorites.asLiveData()

    fun insert(favorite: Favorite) = viewModelScope.launch {
        repository.insert(favorite)
    }

    fun deleteFavorite(favorite: Favorite) = viewModelScope.launch {
        repository.deleteFavorite(favorite)
    }

    fun deleteAllFavorites() = viewModelScope.launch {
        repository.deleteAllFavorites()
    }
}