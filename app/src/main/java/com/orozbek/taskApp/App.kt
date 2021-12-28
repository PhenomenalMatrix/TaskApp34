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
        shopDataBase = Room.databaseBuilder(
            applicationContext,
            AppDataBase::class.java,
            "dataBase"
        ) // Разршение на запросы в главном потоке
//            .allowMainThreadQueries()
            // Игнор. миграции
            .fallbackToDestructiveMigration()
            .build()
        repository = ShopListRepositoryImpl

    }

}