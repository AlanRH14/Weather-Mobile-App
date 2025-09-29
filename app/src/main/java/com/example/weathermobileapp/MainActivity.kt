package com.example.weathermobileapp

import android.Manifest
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.weathermobileapp.navigation.AppNavHost
import com.example.weathermobileapp.ui.theme.WeatherMobileAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WeatherMobileAppTheme {
                Scaffold(
                    modifier = Modifier.Companion
                        .fillMaxSize()
                ) { innerPadding ->
                    AppNavHost(
                        modifier = Modifier.Companion.padding(innerPadding),
                    )
                }
            }
        }
    }
}