package com.example.app.shop

import com.example.app.models.DishItem
import com.example.app.models.Order
import com.example.app.models.Shop

interface ShopService {

    fun getShop(shopId: Int): Shop?

    fun openShop(shopId: Int): Boolean

    fun closeShop(shopId: Int): Boolean

    fun addToMenu(shopId: Int, item: DishItem): DishItem

    fun processOrder(order: Order): Order
}