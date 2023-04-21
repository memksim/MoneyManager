package com.openapp.moneymanager.data.model

data class History(
    val spends: List<Spend>,
    val transfers: List<Transfer>
)
