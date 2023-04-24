package com.openapp.moneymanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.openapp.moneymanager.presentation.main_screen.MainScreenFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(savedInstanceState == null) {
            supportFragmentManager.beginTransaction().add(R.id.fragment_container, MainScreenFragment()).commit()
        }
    }
}