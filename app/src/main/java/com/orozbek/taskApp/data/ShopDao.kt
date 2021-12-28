package com.orozbek.taskApp.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.orozbek.taskApp.domain.ShopItemDbModel

@Dao
interface ShopDao {

    @Query("SELECT * FROM shopitemdbmodel")
    fun getShopList(): LiveData<List<ShopItemDbModel>>

    @Insert
    suspend fun addShopItem(shopItemDbModel: ShopItemDbModel)

}