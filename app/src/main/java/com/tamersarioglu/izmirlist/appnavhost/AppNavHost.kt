package com.tamersarioglu.izmirlist.appnavhost

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.tamersarioglu.izmirlist.presentation.screens.ServicesListScreen
import com.tamersarioglu.izmirlist.presentation.screens.WifiServiceLocationListScreen
import com.tamersarioglu.izmirlist.presentation.screens.serviceslistscreen.ServicesListScreen
import com.tamersarioglu.izmirlist.presentation.screens.wifiservicelocationlistscreen.WifiServiceLocationListScreen

@Composable
fun AppNavHost() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = ServicesListScreen.ROUTE) {
        composable(ServicesListScreen.ROUTE) {
            ServicesListScreen(navController = navController)
        }
        composable(WifiServiceLocationListScreen.ROUTE) {
            WifiServiceLocationListScreen()
        }
    }
}
