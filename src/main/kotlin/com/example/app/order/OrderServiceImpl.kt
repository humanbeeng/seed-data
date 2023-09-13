package com.example.app.order

import com.example.app.models.Order
import com.example.app.shop.ShopService
import com.example.app.shop.ShopServiceImpl
import com.example.app.user.UserService
import com.example.app.user.UserServiceImpl

class OrderServiceImpl(
    private val shopService: ShopService = ShopServiceImpl(),
    private val userService: UserService = UserServiceImpl()
) : OrderService {
    override fun placeOrder(order: Order): Int? {
        val shop = shopService.getShop(order.shopId);
        val user = userService.getUser(order.userId);
        if (shop == null || user == null) {
            return null
        }
        shop.orders.add(order)
        user.orderHistory.add(order)
        order.orderId = shop.orders.size.plus(1)
        return order.orderId
    }

    override fun cancelOrder(orderId: Int, shopId: Int): Boolean {
        val shop = shopService.getShop(shopId) ?: return false
        shop.orders.removeIf { order -> order.orderId == orderId }
        return true
    }

    override fun getAllUserOrders(userId: Int): List<Order> {
        return userService.getUser(userId)?.orderHistory ?: emptyList()
    }

    override fun getAllShopOrders(shopId: Int): List<Order> {
        return shopService.getShop(shopId)?.orders ?: emptyList()
    }
}