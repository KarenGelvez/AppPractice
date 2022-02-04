package com.app.apppractice.data

import com.app.apppractice.data.model.Favorite
import com.app.apppractice.data.network.FavoriteDAO
import kotlinx.coroutines.flow.Flow

class FavoriteRepository(private val favoriteDAO: FavoriteDAO) {
    val allFavorites: Flow<List<Favorite>> = favoriteDAO.getAllFavorites()

    suspend fun insert(favorite: Favorite) {
        favoriteDAO.insert(favorite)
    }

    suspend fun deleteFavorite(favorite: Favorite) {
        favoriteDAO.deleteFavorite(favorite)
    }

    suspend fun deleteAllFavorites() {
        favoriteDAO.deleteAll()
    }
}