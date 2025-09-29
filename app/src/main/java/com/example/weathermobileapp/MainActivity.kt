package com.example.weathermobileapp

import android.Manifest
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.weathermobileapp.navigation.AppNavHost
import com.example.weathermobileapp.presentation.screens.weather.WeatherViewModel
import com.example.weathermobileapp.ui.theme.WeatherMobileAppTheme
import org.koin.androidx.viewmodel.ext.android.getViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        permissionLauncher = registerForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions()
        ) {
            viewModel.getWeatherData()
            viewModel.getWeatherForecastData()
        }
        permissionLauncher.launch(
            arrayOf(
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION,
            )
        )

        setContent {
            WeatherMobileAppTheme {
                Scaffold(
                    modifier = Modifier.Companion
                        .fillMaxSize()
                ) { innerPadding ->
                    AppNavHost(
                        modifier = Modifier.Companion.padding(innerPadding),
                        weatherVM = viewModel
                    )
                }
            }
        }
    }
}