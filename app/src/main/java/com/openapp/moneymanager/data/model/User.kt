package com.openapp.moneymanager.data.model

data class User(
    val name: String,
    val email: String,
    val password: String,
    val cards: List<Card>,
    val spends: List<Spend>,
    val transfers: List<Transfer>
)
