package com.orozbek.taskApp.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.orozbek.taskApp.App
import com.orozbek.taskApp.domain.ShopItem
import com.orozbek.taskApp.domain.ShopListRepository
import java.lang.RuntimeException

object ShopListRepositoryImpl: ShopListRepository {

    private val shopListLD = MutableLiveData<List<ShopItem>>()

    private val shopList = sortedSetOf<ShopItem>({ o1,o2 -> o1.id.compareTo(o2.id) })

    private val mapper = ShopListMapper()

//    private val shopList = mutableListOf<ShopItem>()

    private var autoIncrementId = 0

//    init {
//        for(i in 0 until 10){
//            val item = ShopItem("item $i", i,true)
//            addShopItem(item)
//        }
//    }

    override suspend fun addShopItem(shopItem: ShopItem) {
//    if (shopItem.id == ShopItem.UNDEFINED_ID){
//        shopItem.id = autoIncrementId++
//    }
//        shopList.add(shopItem)
//        updateList()

        App.shopDataBase.shopListDao().addShopItem(mapper.mapEntityToDbModel(shopItem))
    }

    override fun deleteShopItem(shopItem: ShopItem) {
//        shopList.remove(shopItem)
//        updateList()
    }

    override fun editShopItem(shopItem: ShopItem) {
//        val oldElement = getShopItem(shopItem.id)
//        shopList.remove(oldElement)
//        addShopItem(shopItem)

    }

    override fun getShopItem(shopItemId: Int): ShopItem {
//        return shopList.find {
//            it.id == shopItemId
//        } ?: throw RuntimeException ("Element with id $shopItemId not found")
        TODO()
    }

      override fun getShopItemList(): LiveData<List<ShopItem>> = Transformations.map(
          App.shopDataBase.shopListDao().getShopList()
      ){
          mapper.mapListDbModelToListEntity(it)
      }


//    private fun updateList(){
//        shopListLD.value = shopList.toList()
//    }

}