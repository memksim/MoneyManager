package com.openapp.moneymanager.presentation.model

import androidx.annotation.ColorInt
import androidx.annotation.DrawableRes

data class WalletItemUiState(
    val walletName: String,
    val amount: String,
    val date: String,
    @DrawableRes
    val paymentSystemIcon: Int,
    @DrawableRes
    val coverDrawableRes: Int?,
    @ColorInt
    val coverColor: Int?
)
