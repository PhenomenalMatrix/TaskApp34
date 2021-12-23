package com.orozbek.taskApp.data

import androidx.lifecycle.LiveData
import androidx.room.Query
import com.orozbek.taskApp.domain.ShopItemDbModel

interface ShopDao {

    @Query("SELECT * FROM shop_items")
    fun getShopList(): LiveData<List<ShopItemDbModel>>

}