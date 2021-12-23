package com.orozbek.taskApp

import android.app.Application
import androidx.room.Room
import com.orozbek.taskApp.data.AppDataBase
import com.orozbek.taskApp.data.ShopListRepositoryImpl

class App: Application() {

    companion object {
        lateinit var repository: ShopListRepositoryImpl
        lateinit var shopDataBase: AppDataBase
    }

    override fun onCreate() {
        super.onCreate()
        repository = ShopListRepositoryImpl
        shopDataBase = Room.databaseBuilder(this, AppDataBase::class.java,"dataBase")
            .allowMainThreadQueries()
            .build()
    }

}