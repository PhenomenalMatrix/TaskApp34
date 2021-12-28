package com.orozbek.taskApp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.orozbek.taskApp.domain.ShopItemDbModel

@Database(entities = [ShopItemDbModel::class], version = 1)
abstract class AppDataBase: RoomDatabase() {
    abstract fun shopListDao(): ShopDao
}