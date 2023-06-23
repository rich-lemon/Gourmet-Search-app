package com.example.gourmetsearchapp.ui.root.components

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabPosition
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.gourmetsearchapp.ui.NavigationRoute

@Composable
fun MyTabRow(navController: NavController) {
    var state by remember { mutableStateOf(0) }

    TabRow(
        selectedTabIndex = state,
        indicator = { tabPositions ->
            TabRowDefaults.Indicator(
                height = 5.dp,
                modifier = Modifier.myTabOffset(tabPositions[state])
            )
        },
        divider = {
            Divider(thickness = 0.dp)
        }
    ) {
        // NavController
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination
        // route
        val items = listOf(NavigationRoute.GourmetSearch, NavigationRoute.GourmetDetail)

        items.forEachIndexed() { index, screen ->
            MyTab(
                selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                onClick = {
                    state = index
                    navController.navigate(screen.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                selectedIcon = {
                    Icon(
                        screen.selectedIcon,
                        modifier = Modifier.size(35.dp),
                        contentDescription = screen.description,
                        tint = MaterialTheme.colorScheme.primary
                    )
                },
                unSelectedIcon = {
                    Icon(
                        screen.unSelectedIcon,
                        modifier = Modifier.size(35.dp),
                        contentDescription = screen.description,
                        tint = MaterialTheme.colorScheme.onBackground.copy(0.2f)
                    )
                }
            )
        }
    }
}

// offset
fun Modifier.myTabOffset(tabPosition: TabPosition): Modifier = composed {
    val offset by animateDpAsState(
        targetValue = tabPosition.left,
        animationSpec = tween(
            durationMillis = 500,
            easing = FastOutSlowInEasing
        )
    )

    fillMaxWidth()
        .wrapContentSize(Alignment.TopStart)
        .offset(x = offset)
        .width(tabPosition.width)
}

// tab
@Composable
fun MyTab(
    selected: Boolean,
    onClick: () -> Unit,
    selectedIcon: @Composable () -> Unit,
    unSelectedIcon: @Composable () -> Unit
) {
    Tab(
        selected,
        onClick
    ) {
        Box(
            contentAlignment = Alignment.TopCenter
        ) {
            // icon
            Column(
                modifier = Modifier
                    .height(75.dp)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                if (selected) {
                    selectedIcon()
                } else {
                    unSelectedIcon()
                }
            }
            // divider
            Divider(
                thickness = 3.dp,
                color = MaterialTheme.colorScheme.onBackground.copy(0.2f)
            )
        }
    }
}