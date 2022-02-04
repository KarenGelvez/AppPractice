package com.app.apppractice.ui.view.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.app.apppractice.R
import com.app.apppractice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        configNav()
    }

    private fun configNav(){
        NavigationUI.setupWithNavController(binding.bnvMenu, Navigation.findNavController(this, R.id.fragContent))
    }

}