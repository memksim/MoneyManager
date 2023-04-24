package com.openapp.moneymanager.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.openapp.moneymanager.base.mvi.Action

abstract class BaseFragment<B : ViewBinding> : Fragment() {

    abstract var binding: B?
    abstract val viewModel: BaseViewModel

    abstract fun observeAction(action: Action)

    abstract fun onBind(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): View

    abstract fun onBound(): Unit?

    abstract fun onUnbind()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = onBind(inflater, container)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onBound()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        onUnbind()
    }

}
