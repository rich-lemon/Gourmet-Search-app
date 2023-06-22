package com.example.gourmetsearchapp.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector

sealed class NavigationRoute(var route: String, var icon: ImageVector, var description: String) {
    object GourmetSearch : NavigationRoute("gourmetSearch", Icons.Filled.Home, "グルメ検索")
    object GourmetDetail : NavigationRoute("gourmetDetail", Icons.Filled.Home, "グルメ詳細")
}