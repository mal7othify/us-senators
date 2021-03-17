package com.example.ussenators.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    background = Color.DarkGray,
    surface = Color.Black,
    onBackground = Color.White,
    onSurface = Color.White,
    onPrimary = Color.White
)

private val LightColorPalette = lightColors(
    background = lightWhite,
    surface = Color.White,
    onBackground = gray,
    onSurface = lightGray,
    onPrimary = Color.DarkGray
)

@Composable
fun USSenatorsTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable() () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}
