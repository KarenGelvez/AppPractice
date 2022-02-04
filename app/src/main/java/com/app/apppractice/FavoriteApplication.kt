package com.app.apppractice

import android.app.Application
import com.app.apppractice.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class FavoriteApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@FavoriteApplication)
            modules(appModule)
        }
    }
}