package com.openapp.moneymanager.data.model

data class User(
    val token: String,
    val name: String,
    val email: String,
    val password: String,
    val cards: List<Card>,
    val history: History
)
