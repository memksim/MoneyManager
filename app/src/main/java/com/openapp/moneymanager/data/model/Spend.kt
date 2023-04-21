package com.openapp.moneymanager.data.model

import java.util.*

data class Spend(
    val card: Card,
    val date: Date,
    val amount: String,
    val category: SpendCategory
) {
    data class SpendCategory(
        val title: String
    )
}
