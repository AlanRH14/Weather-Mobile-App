package com.example.weathermobileapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.weathermobileapp.presentation.screens.WeatherScreen
import com.example.weathermobileapp.presentation.screens.WeatherViewModel

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    weatherVM: WeatherViewModel = hiltViewModel()
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Weather.route
    ) {
        composable(Screen.Weather.route) {
            WeatherScreen(
                modifier = modifier,
                weatherVM = weatherVM
            )
        }

        composable(Screen.NextDaysForecast.route) {}
    }
}