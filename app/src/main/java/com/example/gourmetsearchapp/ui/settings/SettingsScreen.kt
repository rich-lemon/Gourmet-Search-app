package com.example.gourmetsearchapp.ui.settings

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.gourmetsearchapp.ui.gourmetsearch.GourmetSearchViewModel
import com.example.gourmetsearchapp.ui.theme.GourmetSearchAppTheme

@Composable
fun SettingsScreen(
    viewModel: SettingsViewModel
) {
    val radioOptions = listOf("300", "500", "1000", "2000", "3000")
    val (selectedOption, onOptionSelected) = remember { mutableStateOf(radioOptions[4]) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            Modifier.selectableGroup(),
            verticalArrangement = Arrangement.Center,
        ) {
            radioOptions.forEach { text ->
                Row(
                    Modifier
                        .height(60.dp)
                        .selectable(
                            selected = (text == selectedOption),
                            onClick = {
                                onOptionSelected(text)
                                // 検索範囲を指定
                                viewModel.setRange(range = radioOptions.indexOf(text) + 1)
                                Log.d("radio button", "range: ${viewModel.state.value.range}")
                            },
                            role = Role.RadioButton
                        )
                        .padding(horizontal = 16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = (text == selectedOption),
                        onClick = null
                    )
                    Text(
                        text = text,
                        style = MaterialTheme.typography.titleMedium.merge(),
                        modifier = Modifier.padding(start = 30.dp),
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }
        }
    }
}

@Preview()
@Composable
fun RootScreenPreview() {
    GourmetSearchAppTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
//            SettingsScreen()
        }
    }
}