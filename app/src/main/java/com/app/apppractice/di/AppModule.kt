package com.app.apppractice.di

import com.app.apppractice.data.FavoriteRepository
import com.app.apppractice.data.ShoppingCartRepository
import com.app.apppractice.data.network.ProductService
import com.app.apppractice.data.network.RetrofitHelper
import com.app.apppractice.data.network.RoomDB
import com.app.apppractice.ui.viewmodel.FavoriteViewModel
import com.app.apppractice.ui.viewmodel.ShoppingCartViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single {
        RoomDB.getDataBase(androidContext())
    }
    single {
        get<RoomDB>().favoriteDao()
    }
    factory {
        FavoriteRepository(get())
    }
    viewModel {
        FavoriteViewModel(get())
    }

    single {
        get<RoomDB>().shoppingCartDao()
    }
    factory {
        ShoppingCartRepository(get())
    }
    viewModel {
        ShoppingCartViewModel(get())
    }

    single {
        RetrofitHelper.getRetrofitProducts()
    }
}