package com.puntogris.conexachallenge.utils

import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.puntogris.conexachallenge.R

fun AppCompatActivity.getNavHostFragment(): NavHostFragment {
    return supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
}

fun AppCompatActivity.getNavController(): NavController {
    return getNavHostFragment().navController
}