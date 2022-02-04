package com.app.apppractice.data.network

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.app.apppractice.data.model.Favorite
import com.app.apppractice.data.model.ShoppingCart

@Database(
    entities = [Favorite::class, ShoppingCart::class],
    version = 3,
    exportSchema = false
)
abstract class RoomDB : RoomDatabase() {
    abstract fun favoriteDao(): FavoriteDAO
    abstract fun shoppingCartDao(): ShoppingCartDAO

    companion object {
        @Volatile
        private var INSTANCE: RoomDB? = null

        fun getDataBase(context: Context): RoomDB {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    RoomDB::class.java,
                    "app_database"
                ).fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}