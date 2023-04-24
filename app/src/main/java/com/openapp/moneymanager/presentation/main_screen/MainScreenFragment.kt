package com.openapp.moneymanager.presentation.main_screen

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.openapp.moneymanager.R
import com.openapp.moneymanager.base.BaseFragment
import com.openapp.moneymanager.base.BaseViewModel
import com.openapp.moneymanager.base.mvi.Action
import com.openapp.moneymanager.databinding.FragmentMainScreenBinding

class MainScreenFragment : BaseFragment<FragmentMainScreenBinding>() {

    override var binding: FragmentMainScreenBinding? = null
    override val viewModel: MainScreenViewModel by viewModels()

    override fun observeAction(action: Action) {
        //todo
    }

    override fun onBind(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): View {
        val view = inflater.inflate(R.layout.fragment_main_screen, container, false)
        binding = FragmentMainScreenBinding.bind(view)
        return binding?.root ?: view
    }

    override fun onBound() = binding?.let {
        with(it) {
            //todo
        }
    }

    override fun onUnbind() {
        binding = null
    }

}
