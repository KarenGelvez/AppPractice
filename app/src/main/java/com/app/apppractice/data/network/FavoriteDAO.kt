package com.app.apppractice.data.network

import androidx.room.*
import com.app.apppractice.data.model.Favorite
import com.app.apppractice.data.model.ProductModel
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteDAO {
    @Query("SELECT * FROM favorite_table")
    fun getAllFavorites(): Flow<List<Favorite>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(favorite: Favorite)

    @Query("DELETE FROM favorite_table")
    suspend fun deleteAll()

    @Delete
    suspend fun deleteFavorite(favorite: Favorite)
}