package com.example.app.shop

import com.example.app.models.DishItem
import com.example.app.models.Order
import com.example.app.models.OrderConfirmation
import com.example.app.models.Shop

class ShopServiceImpl(
    private val shops: List<Shop> = listOf(
        Shop(1, "Ramu Chats"),
        Shop(2, "Sidda Hotel")
    )
) : ShopService {

    override fun getShop(shopId: Int): Shop? {
        return shops.firstOrNull { shop -> shop.shopId == shopId }
    }


    override fun openShop(shopId: Int): Boolean {
        shops.first { shop: Shop -> shop.shopId == shopId }.open = true
        return true
    }

    override fun closeShop(shopId: Int): Boolean {
        shops.first { shop -> shop.shopId == shopId }.open = false
        return true
    }

    override fun addToMenu(shopId: Int, item: DishItem): DishItem {
        shops.first { shop -> shop.shopId == shopId }.items.add(item)
        return item
    }

    override fun processOrder(order: Order): Order {
        val shop = shops.firstOrNull { shop -> shop.shopId == order.shopId }
        return if (shop != null) {
            if (shop.orders.size > 10) {
                order.status = OrderConfirmation.REJECTED
                order
            } else {
                order.status = OrderConfirmation.CONFIRMED
                shop.orders.add(order)
                order
            }
        } else {
            order.status = OrderConfirmation.REJECTED
            order
        }
    }
}