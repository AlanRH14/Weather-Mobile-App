package com.example.weathermobileapp

import  android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.weathermobileapp.presentation.screens.WeatherScreen
import com.example.weathermobileapp.ui.theme.WeatherMobileAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WeatherMobileAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    WeatherScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFFFFFFFF,
    widthDp = 390,
    heightDp = 800
)
@Composable
fun ScreenPreview() {
    WeatherMobileAppTheme {
        WeatherScreen()
    }
}