package com.example.gourmetsearchapp.ui.root.components

import android.Manifest
import android.content.pm.PackageManager
import android.location.Location
import android.util.Log
import androidx.activity.result.ActivityResultLauncher
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.core.app.ActivityCompat
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.example.gourmetsearchapp.ui.NavigationRoute
import com.example.gourmetsearchapp.ui.gourmetsearch.GourmetSearchViewModel
import com.example.gourmetsearchapp.ui.settings.SettingsViewModel
import com.example.gourmetsearchapp.ui.theme.GourmetSearchAppTheme
import com.google.android.gms.location.LocationServices
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun MyFloatingActionButton(
    navController: NavController,
    locationPermissionRequest: ActivityResultLauncher<Array<String>>,
    viewModel: GourmetSearchViewModel,
    viewModel2: SettingsViewModel
) {
    // location
    val context = LocalContext.current
    val locationClient = remember {
        LocationServices.getFusedLocationProviderClient(context)
    }

    FloatingActionButton(
        onClick = {
            // Gourmet Search Screenにジャンプ
            navController.navigate(NavigationRoute.GourmetSearch.route) {
                popUpTo(navController.graph.findStartDestination().id) {
                    saveState = true
                }
                launchSingleTop = true
                restoreState = true
            }

            // location
            if (ActivityCompat.checkSelfPermission(
                    context,
                    Manifest.permission.ACCESS_FINE_LOCATION
                ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                    context,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                // 位置情報へのアクセスをリクエスト
                locationPermissionRequest.launch(
                    arrayOf(
                        Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.ACCESS_COARSE_LOCATION
                    )
                )
            } else {
                // 現在地を取得
                locationClient.lastLocation
                    .addOnSuccessListener { location: Location? ->
                        val lat = location?.latitude?.toFloat()
                        val lng = location?.longitude?.toFloat()
                        Log.d("location", "latitude： $lat")
                        Log.d("location", "longitude: $lng")
                        if (lat != null && lng != null) {
                            viewModel.searchGourmet(
                                lat = lat ?: lat, // 緯度
                                lng = lng ?: lng, // 経度
                                range = viewModel2.state.value.range
                            )
                        }
                    }
            }
        },
        modifier = Modifier
            .size(80.dp)
            .border(
                width = 3.dp,
                color = MaterialTheme.colorScheme.secondary,
                shape = hexagonShape()
            ),
        shape = hexagonShape(),
        containerColor = MaterialTheme.colorScheme.primary,
        contentColor = MaterialTheme.colorScheme.onPrimary,
        elevation = FloatingActionButtonDefaults.elevation(0.dp, 0.dp, 0.dp, 0.dp)
    ) {
        Icon(
            Icons.Filled.Search,
            modifier = Modifier.size(35.dp),
            contentDescription = "検索ボタン"
        )
    }
}

// 六角形
class hexagonShape : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        val path = Path().apply {
            val radius = size.width / 2f

            // 六角形
            moveTo(radius, 0f)
            lineTo(
                radius + radius * cos(PI * 11 / 6).toFloat(),
                radius + radius * sin(PI * 11 / 6).toFloat()
            )
            lineTo(
                radius + radius * cos(PI / 6).toFloat(),
                radius + radius * sin(PI / 6).toFloat()
            )
            lineTo(radius, size.height) // 4
            lineTo(
                radius + radius * cos(PI * 5 / 6).toFloat(),
                radius + radius * sin(PI * 5 / 6).toFloat()
            )
            lineTo(
                radius + radius * cos(PI * 7 / 6).toFloat(),
                radius + radius * sin(PI * 7 / 6).toFloat()
            )
            close()
        }

        return Outline.Generic(path)
    }
}

@Preview()
@Composable
fun MyFloatingActionButtonPreview() {
    GourmetSearchAppTheme() {
//        MyFloatingActionButton()
    }
}