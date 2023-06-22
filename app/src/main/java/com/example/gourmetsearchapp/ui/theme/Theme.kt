package com.example.gourmetsearchapp.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorScheme = darkColorScheme(
    primary = Color.Cyan,
    onPrimary = Color.White,

    secondary = Color.Green,
    onSecondary = Color.Green,

    tertiary = Color.Green,
    onTertiary = Color.Green,

    background = Color.Black,
    onBackground = Color.Green,

    surface = Color.Transparent,
    onSurface = Color.Green
)

private val LightColorScheme = lightColorScheme(
    primary = Color.Magenta,
    onPrimary = Color.Cyan,

    secondary = Color.Green,
    onSecondary = Color.Green,

    tertiary = Color.Green,
    onTertiary = Color.Green,

    background = Color.White,
    onBackground = Color.Black,

    surface = Color.Transparent,
    onSurface = Color.Green
)

@Composable
fun GourmetSearchAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false, // Android 12以上でダイナミックカラー
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb() // ステータスバー
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}