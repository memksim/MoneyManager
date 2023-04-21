package com.openapp.moneymanager.presentation.main_screen

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import com.openapp.moneymanager.R
import com.openapp.moneymanager.databinding.FragmentMainScreenBinding

class MainScreenFragment : Fragment() {

    private var _binding: FragmentMainScreenBinding? = null
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = LayoutInflater.from(context).inflate(inflater, container, false)
        _binding = FragmentMainScreenBinding.bind(view)

        return binding?.root ?: view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.let {
            with(it) {
                //todo
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
