package com.example.weathermobileapp.presentation.components

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import com.example.weathermobileapp.ui.theme.ShimmerColorGradient

@Composable
fun Modifier.shimmerEffect(): Modifier = composed {
    val transition = rememberInfiniteTransition(label = "shimmer")
    val shimmerAnimation = transition.animateFloat(
        initialValue = 0F,
        targetValue = 1000F,
        animationSpec = infiniteRepeatable(animation = tween(1000, easing = LinearEasing)),
        label = "shimmer"
    )

    background(
        Brush.linearGradient(
            colors = ShimmerColorGradient,
            start = Offset.Zero,
            end = Offset(x = shimmerAnimation.value, y = shimmerAnimation.value * 2)
        )
    )
}