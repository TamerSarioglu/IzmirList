package com.tamersarioglu.izmirlist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.tamersarioglu.izmirlist.appnavhost.AppNavHost
import com.tamersarioglu.izmirlist.presentation.screens.wifiservicelocationlistscreen.WifiServiceLocationListScreen
import com.tamersarioglu.izmirlist.presentation.ui.theme.IzmirListTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            IzmirListTheme {
                AppNavHost()
            }
        }
    }
}