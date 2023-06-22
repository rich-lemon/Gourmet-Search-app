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
        fontWeight = FontWeight.SemiBold,
        textAlign = TextAlign.Center
    ),
    titleMedium = TextStyle(
        color = Color.Magenta,
        fontSize = 22.sp,
        fontWeight = FontWeight.Normal,
        textAlign = TextAlign.Center
    ),
    bodyMedium = TextStyle(
        color = Color.Black,
        fontSize = 16.sp,
        fontWeight = FontWeight.Normal,
        textAlign = TextAlign.Center
    ),
    labelMedium = TextStyle(
        color = Color.Gray,
        fontSize = 14.sp,
        fontWeight = FontWeight.Medium,
        textAlign = TextAlign.Center
    )
)