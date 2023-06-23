package com.example.gourmetsearchapp.ui.gourmetsearch

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.example.gourmetsearchapp.ui.NavigationRoute
import com.example.gourmetsearchapp.ui.gourmetsearch.components.GourmetCard
import com.example.gourmetsearchapp.ui.theme.GourmetSearchAppTheme
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

@Composable
fun GourmetSearchScreen(
    navController: NavController,
    viewModel: GourmetSearchViewModel
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        val state = viewModel.state.value

        items(state.gourmets) { gourmet ->
            val url = URLEncoder.encode(gourmet.mobile_l, StandardCharsets.UTF_8.toString())
            val logoImage = URLEncoder.encode(gourmet.logo_image, StandardCharsets.UTF_8.toString())
            val name = URLEncoder.encode(gourmet.name, StandardCharsets.UTF_8.toString())
            val address = URLEncoder.encode(gourmet.address, StandardCharsets.UTF_8.toString())
            val open = URLEncoder.encode(gourmet.open, StandardCharsets.UTF_8.toString())
            val close = URLEncoder.encode(gourmet.close, StandardCharsets.UTF_8.toString())

            GourmetCard(
                gourmet = gourmet,
                onClick = {
                    navController.navigate(
                        NavigationRoute.GourmetDetail.route
                                + "/${url}/${logoImage}/${name}/${address}/${open}/${close}"
                    ) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
//    LazyColumn(
//        modifier = Modifier.padding(it)
//    ) {
//        val state = ViewModel.state.value
//
//        items(state.gourmets) { gourmet ->
//            GourmetCard(gourmet = gourmet, onClick = {})
//        }
//    }
}
