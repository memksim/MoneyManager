package com.openapp.moneymanager.data.model

import java.util.Date

data class Transfer(
    val sender: Card,
    val receiver: Card,
    val date: Date,
    val amount: String
)
