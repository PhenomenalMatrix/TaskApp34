package com.orozbek.taskApp.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.orozbek.taskApp.App
import com.orozbek.taskApp.data.ShopListRepositoryImpl
import com.orozbek.taskApp.domain.*

class MainViewModel: ViewModel() {

    private val addShopItemUseCase = AddShopItemUseCase(App.repository)
    private val getShopListUseCase = GetShopListUseCase(App.repository)
    private val getShopItemUseCase = GetShopItemUseCase(App.repository)
    private val editShopItemUseCase = EditShopItemUseCase(App.repository)
    private val deleteShopItemUseCase = DeleteShopItemUseCase(App.repository)

    val shopList = getShopListUseCase.getShopItemList()
    val shopItem = MutableLiveData<ShopItem>()


    fun getShopItem(id: Int){
        val item = getShopItemUseCase.getShopItem(id)
        shopItem.value = item
    }

//    fun changeEnableState(shopItem: ShopItem){
//        val newItem = shopItem.copy(enabled = !shopItem.enabled)
//        editShopItemUseCase.editShopItem(newItem)
//    }
//
//    fun deleteItem(shopItem: ShopItem){
//        deleteShopItemUseCase.deleteShopItem(shopItem)
//    }





}