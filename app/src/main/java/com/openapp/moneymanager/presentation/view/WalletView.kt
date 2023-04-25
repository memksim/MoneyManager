package com.openapp.moneymanager.presentation.view

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.annotation.ColorInt
import androidx.annotation.DrawableRes
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.res.ResourcesCompat
import com.openapp.moneymanager.R
import com.openapp.moneymanager.databinding.WalletViewBinding

class WalletView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(
    context,
    attrs,
    defStyleAttr,
) {
    private val binding: WalletViewBinding

    init {
        val view = LayoutInflater.from(context)
            .inflate(R.layout.wallet_view, this, true)
        binding = WalletViewBinding.bind(view)
        initAttrs(attrs, defStyleAttr, R.style.DefaultWalletStyle)
    }

    var walletBalance: String = ""
        set(value) {
            field = value
            binding.tvTotalBalance.text = field
            invalidate()
        }

    var last4Numbers: String = ""
        set(value) {
            field = value
            binding.tvLastNumbers.text = field
            invalidate()
        }

    var walletName: String = ""
        set(value) {
            field = value
            binding.tvWalletName.text = field
            invalidate()
        }

    var dateText: String = ""
        set(value) {
            field = value
            binding.tvDate.text = field
            invalidate()
        }

    @ColorInt
    var allTextColor: Int = Color.WHITE
        set(value) {
            field = value
            with(binding) {
                tvTotalBalanceTitle.setTextColor(field)
                tvTotalBalance.setTextColor(field)
                tvLastNumbers.setTextColor(field)
                tvWalletName.setTextColor(field)
                tvDate.setTextColor(field)
                //dots view must have same color as the text
                ivDots.setColorFilter(field)
            }
            invalidate()
        }

    private val defaultCoverColor = Color.parseColor("#7BE495")
    @ColorInt
    var coverColor: Int? = null
        set(value) {
            field = value
            field?.let {
                //must replace the background, otherwise the color will not be displayed
                ResourcesCompat.getDrawable(resources, coverDrawableRes ?: defaultCoverDrawableRes, context.theme)
                binding.clWallet.backgroundTintList = ColorStateList.valueOf(it)
            }
            invalidate()
        }

    private val defaultCoverDrawableRes = R.drawable.card_back
    @DrawableRes
    var coverDrawableRes: Int? = defaultCoverDrawableRes
        set(value) {
            field = value ?: defaultCoverDrawableRes
            field?.let {
                binding.clWallet.background =
                    ResourcesCompat.getDrawable(resources, it, context.theme)
                //if we have a background - clear back color
                if(it != defaultCoverDrawableRes) coverColor = null
            }
            invalidate()
        }

    @DrawableRes
    var paymentSystemDrawableRes: Int = R.drawable.ic_ruble_light
        set(value) {
            field = value
            binding.ivPaymentIcon.setImageDrawable(ResourcesCompat.getDrawable(resources, value, context.theme))
            invalidate()
        }

    private fun initAttrs(attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) =
        with(binding) {
            val typedArray = context.obtainStyledAttributes(
                attrs,
                R.styleable.WalletView,
                defStyleAttr,
                defStyleRes
            )
            try {
                //set color of all items
                allTextColor = typedArray.getColor(
                    R.styleable.WalletView_allTextColor,
                    allTextColor
                )

                //set texts
                walletBalance = typedArray.getString(R.styleable.WalletView_amountText).orEmpty()
                last4Numbers = typedArray.getString(R.styleable.WalletView_last4NumbersText).orEmpty()
                walletName = typedArray.getString(R.styleable.WalletView_walletNameText).orEmpty()
                dateText = typedArray.getString(R.styleable.WalletView_dateText).orEmpty()

                //set card background & color
                coverDrawableRes =
                    typedArray.getResourceId(R.styleable.WalletView_walletCoverDrawable, coverDrawableRes ?: defaultCoverDrawableRes)
                if(coverDrawableRes == defaultCoverDrawableRes) {
                    coverColor =
                        typedArray.getColor(R.styleable.WalletView_walletCoverColor, coverColor ?: defaultCoverColor)
                }

                //set payment system icon
                paymentSystemDrawableRes =
                    typedArray.getResourceId(R.styleable.WalletView_paymentSystemDrawable, paymentSystemDrawableRes)
                binding.ivPaymentIcon.setImageDrawable(ResourcesCompat.getDrawable(resources, paymentSystemDrawableRes, context.theme))

            } catch (e: Throwable) {
                //todo
            } finally {
                typedArray.recycle()
            }
        }
}