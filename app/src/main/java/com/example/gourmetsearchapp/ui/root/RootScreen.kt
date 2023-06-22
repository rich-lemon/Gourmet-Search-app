package com.example.gourmetsearchapp.ui.root

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.gourmetsearchapp.ui.NavigationRoute
import com.example.gourmetsearchapp.ui.gourmetsearch.GourmetSearchScreen
import com.example.gourmetsearchapp.ui.gourmetdetail.GourmetDetailScreen
import com.example.gourmetsearchapp.ui.root.components.MyTabRow
import com.example.gourmetsearchapp.ui.theme.GourmetSearchAppTheme

@Composable
fun RootScreen() {
    // NavController
    val navController = rememberNavController()

    Box(
        modifier = Modifier.fillMaxSize()
    ) {


        Column {
            // title
            Text(
                "Restaurant",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 20.dp),
                color = MaterialTheme.colorScheme.primary,
                style = MaterialTheme.typography.headlineMedium,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )

            // MyTabRow
            MyTabRow(navController)

            Surface(
                modifier = Modifier.fillMaxSize()
            ) {
                // NavHost
                NavHost(
                    navController = navController,
                    startDestination = NavigationRoute.GourmetSearch.route
                ) {
                    // ホーム画面
                    composable(NavigationRoute.GourmetSearch.route) {
                        GourmetSearchScreen()
                    }
                    // 統計画面
                    composable(NavigationRoute.GourmetDetail.route) {
                        GourmetDetailScreen()
                    }
                }
            }


        }
    }
}

@Preview()
@Composable
fun RootScreenPreview() {
    GourmetSearchAppTheme {
        RootScreen()
    }
}