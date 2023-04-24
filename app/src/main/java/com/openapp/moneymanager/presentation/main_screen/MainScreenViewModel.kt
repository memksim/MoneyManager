package com.openapp.moneymanager.presentation.main_screen

import com.openapp.moneymanager.base.BaseViewModel
import com.openapp.moneymanager.base.mvi.State
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MainScreenViewModel(
    //hilt
): BaseViewModel() {

    private val _viewState: MutableStateFlow<State> = MutableStateFlow(object : State {})//todo
    override val viewState: StateFlow<State>
        get() = _viewState

    protected override fun reduce() {

    }

}