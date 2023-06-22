package com.example.gourmetsearchapp.ui.gourmetsearch

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.gourmetsearchapp.ui.gourmetsearch.components.GourmetCard
import com.example.gourmetsearchapp.ui.theme.GourmetSearchAppTheme

@Composable
fun GourmetSearchScreen(ViewModel: GourmetSearchViewModel = hiltViewModel()) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        val state = ViewModel.state.value

        items(state.gourmets) { gourmet ->
            GourmetCard(gourmet = gourmet, onClick = {})
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

@Preview(showBackground = true)
@Composable
fun GourmetSearchScreenPreview() {
    GourmetSearchAppTheme() {
        GourmetSearchScreen()
    }
}