package com.example.app.models

import java.math.BigDecimal

data class Order(
    var orderId: Int,
    val userId: Int,
    val shopId: Int,
    val items: List<DishItem>,
    val amount: BigDecimal,
    var status: OrderConfirmation
)
