package com.example.app.order

import com.example.app.models.Order

interface OrderService {
    fun placeOrder(order: Order): Int?

    fun cancelOrder(orderId: Int, shopId: Int): Boolean

    fun getAllUserOrders(userId: Int): List<Order>

    fun getAllShopOrders(shopId: Int): List<Order>
}