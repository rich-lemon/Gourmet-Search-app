package com.example.gourmetsearchapp.ui.root

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
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
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.gourmetsearchapp.ui.NavigationRoute
import com.example.gourmetsearchapp.ui.gourmetsearch.GourmetSearchScreen
import com.example.gourmetsearchapp.ui.gourmetdetail.GourmetDetailScreen
import com.example.gourmetsearchapp.ui.root.components.MyFloatingActionButton
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

            // contents
            BoxWithConstraints {
                Surface(
                    modifier = Modifier.height(maxHeight - 75.dp)
                ) {
                    // NavHost
                    NavHost(
                        navController = navController,
                        startDestination = NavigationRoute.GourmetSearch.route,
                    ) {
                        // グルメ検索画面
                        composable(NavigationRoute.GourmetSearch.route) {
                            GourmetSearchScreen(navController)
                        }
                        // グルメ詳細画面
                        composable(NavigationRoute.GourmetDetail.route) {
                            GourmetDetailScreen(null, null, "", "", "", "")
                        }
                        // グルメ詳細画面（URLあり）
                        composable(
                            NavigationRoute.GourmetDetail.route
                                    + "/{url}/{logoImage}/{name}/{address}/{open}/{close}",
                            arguments = listOf(
                                navArgument("url") { type = NavType.StringType },
                                navArgument("logoImage") { type = NavType.StringType },
                                navArgument("name") { type = NavType.StringType },
                                navArgument("address") { type = NavType.StringType },
                                navArgument("open") { type = NavType.StringType },
                                navArgument("close") { type = NavType.StringType },
                            )
                        ) { backStackEntry ->
                            val url = backStackEntry.arguments?.getString("url")
                            val logoImage = backStackEntry.arguments?.getString("logoImage")
                            val name = backStackEntry.arguments?.getString("name") ?: ""
                            val address = backStackEntry.arguments?.getString("address") ?: ""
                            val open = backStackEntry.arguments?.getString("open") ?: ""
                            val close = backStackEntry.arguments?.getString("close") ?: ""
                            GourmetDetailScreen(url, logoImage, name, address, open, close)
                        }
                    }
                }
            }

            // MyTabRow
            MyTabRow(navController)
        }

        // floating action button
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.BottomCenter
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                MyFloatingActionButton()
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(33.dp)
                )
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