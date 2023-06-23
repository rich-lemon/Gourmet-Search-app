package com.example.gourmetsearchapp.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

val Typography = Typography(
    displayMedium = TextStyle(
        fontSize = 45.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center
    ),
    headlineMedium = TextStyle(
        fontSize = 28.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center
    ),
    titleMedium = TextStyle(
        color = Color.Magenta,
        fontSize = 22.sp,
        fontWeight = FontWeight.SemiBold,
    ),
    bodyMedium = TextStyle(
        color = Color.Black,
        fontSize = 14.sp,
        fontWeight = FontWeight.Normal,
    ),
    labelMedium = TextStyle(
        color = Color.Black,
        fontSize = 12.sp,
        fontWeight = FontWeight.Medium,
    )
)