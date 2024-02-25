package com.puntogris.conexachallenge.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.puntogris.conexachallenge.R
import com.puntogris.conexachallenge.databinding.ActivityMainBinding
import com.puntogris.conexachallenge.utils.getNavController
import com.puntogris.conexachallenge.utils.viewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val binding by viewBinding(ActivityMainBinding::inflate)

    private lateinit var navController: NavController

    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupNavigation()
    }

    private fun setupNavigation() {
        navController = getNavController()
        appBarConfiguration = AppBarConfiguration(
            setOf(R.id.searchFragment, R.id.usersFragment)
        )

        binding.bottomNavigation.setOnItemSelectedListener {
            navController.navigate(it.itemId)
            true
        }

        setSupportActionBar(binding.toolbar)
        setupActionBarWithNavController(navController, appBarConfiguration)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}

