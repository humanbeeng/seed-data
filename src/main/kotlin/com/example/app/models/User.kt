package com.example.app.models

data class User(
    val id: Int,
    val name: String,
    val age: Int,
    val orderHistory: MutableList<Order>
)
