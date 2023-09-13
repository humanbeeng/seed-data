package com.example.app.user

import com.example.app.models.Order
import com.example.app.models.User
import com.example.app.models.Vendor

interface UserService {

    fun getUser(userId: Int): User?

    fun login(user: User): Boolean;

    fun addToUserHistory(userId: Int, order: Order): Boolean

    fun makeUserVendor(userId: Int): Vendor?
}