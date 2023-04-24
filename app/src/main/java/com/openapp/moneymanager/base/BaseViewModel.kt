package com.openapp.moneymanager.base

import androidx.lifecycle.ViewModel
import com.openapp.moneymanager.base.mvi.State
import kotlinx.coroutines.flow.StateFlow

abstract class BaseViewModel: ViewModel() {

    abstract val viewState: StateFlow<State>

    protected abstract fun reduce()

}