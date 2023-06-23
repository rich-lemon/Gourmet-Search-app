package com.example.gourmetsearchapp.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Restaurant
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.List
import androidx.compose.material.icons.outlined.Restaurant
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class NavigationRoute(
    var route: String,
    var selectedIcon: ImageVector,
    var unSelectedIcon: ImageVector,
    var description: String
) {
    object GourmetSearch : NavigationRoute(
        "gourmetSearch",
        selectedIcon = Icons.Filled.Restaurant,
        unSelectedIcon = Icons.Outlined.Restaurant,
        "グルメ検索"
    )

    object GourmetDetail : NavigationRoute(
        "gourmetDetail",
        selectedIcon = Icons.Filled.Settings,
        unSelectedIcon = Icons.Outlined.Settings,
        "グルメ詳細"
    )
}