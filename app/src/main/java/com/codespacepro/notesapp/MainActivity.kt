package com.codespacepro.notesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavHostController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val NavHostController = navHostFragment.navController
        setupActionBarWithNavController(NavHostController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return findNavController(R.id.fragmentContainerView).navigateUp() || super.onSupportNavigateUp()
    }
}