package com.orozbek.taskApp.data

import com.orozbek.taskApp.domain.ShopItem
import com.orozbek.taskApp.domain.ShopItemDbModel

class ShopListMapper {

    fun mapEntityToDbModel(shopItem: ShopItem) = ShopItemDbModel(
        id = shopItem.id,
        name = shopItem.name,
        count = shopItem.count,
        enabled =  shopItem.enabled
    )

    fun mapDbToEntity(shopItemDbModel: ShopItemDbModel) = ShopItem(
        id = shopItemDbModel.id,
        name = shopItemDbModel.name,
        count = shopItemDbModel.count,
        enabled =  shopItemDbModel.enabled
    )

    fun mapListDbModelToListEntity(list: List<ShopItemDbModel>) = list.map {
        mapDbToEntity(it)
    }

}