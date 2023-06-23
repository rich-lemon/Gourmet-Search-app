package com.example.gourmetsearchapp.ui.settings

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class SettingsViewModel : ViewModel() {
    private val _state = mutableStateOf(SettingsState())
    val state: State<SettingsState> = _state

    // 検索半径をセット
    fun setRange(range: Int) {
        _state.value = SettingsState(range = range)
    }

    // get
//    fun getRange(): Int {
////        return state.getValue(SettingsState()).range
//    }
}