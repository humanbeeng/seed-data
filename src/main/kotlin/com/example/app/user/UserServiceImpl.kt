package com.example.app.user

import com.example.app.models.Order
import com.example.app.models.User
import com.example.app.models.Vendor

class UserServiceImpl(
    private val users: MutableList<User> = mutableListOf(
        User(id = 1, name = "Nithin", age = 23, mutableListOf()),
        User(id = 2, name = "Raju", age = 24, mutableListOf()),
    ),
    private val vendors: MutableList<Vendor> = mutableListOf()
) : UserService {
    override fun getUser(userId: Int): User? {
        return users.firstOrNull { user -> user.id == userId }
    }

    override fun login(user: User): Boolean {
        return user.name == "Nithin"
    }

    override fun addToUserHistory(userId: Int, order: Order): Boolean {
        val user = users.firstOrNull { user -> user.id == userId } ?: return false
        user.orderHistory.add(order);
        return true
    }

    override fun makeUserVendor(userId: Int): Vendor? {
        val user = users.firstOrNull { user -> user.id == userId } ?: return null
        val vendor = Vendor(name = user.name, shopId = 1)
        vendors.add(vendor)
        return vendor
    }

}