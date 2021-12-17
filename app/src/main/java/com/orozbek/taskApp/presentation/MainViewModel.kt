package com.orozbek.taskApp.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.orozbek.taskApp.data.ShopListRepositoryImpl
import com.orozbek.taskApp.domain.*

class MainViewModel: ViewModel() {

    private val repository = ShopListRepositoryImpl
    private val addShopItemUseCase = AddShopItemUseCase(repository)
    private val getShopListUseCase = GetShopListUseCase(repository)
    private val getShopItemUseCase = GetShopItemUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)

    val shopList = getShopListUseCase.getShopItemList()
    val shopItem = MutableLiveData<ShopItem>()


    fun getShopItem(id: Int){
        val item = getShopItemUseCase.getShopItem(id)
        shopItem.value = item
    }

    fun changeEnableState(shopItem: ShopItem){
        val newItem = shopItem.copy(enabled = !shopItem.enabled)
        editShopItemUseCase.editShopItem(newItem)
    }



}