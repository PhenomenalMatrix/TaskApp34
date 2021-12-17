package com.orozbek.taskApp.domain

class GetShopItemUseCase(private val repository: ShopListRepository) {

    fun getShopItem(id: Int): ShopItem{
        return repository.getShopItem(id)
    }

}