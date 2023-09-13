package com.example.app.models

data class Shop(
    val shopId: Int,
    val name: String,
    var open: Boolean = false,
    val items: MutableList<DishItem> = mutableListOf(),
    val orders: MutableList<Order> = mutableListOf()
)
