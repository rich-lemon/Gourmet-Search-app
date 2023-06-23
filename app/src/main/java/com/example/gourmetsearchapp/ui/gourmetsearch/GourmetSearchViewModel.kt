package com.example.gourmetsearchapp.ui.gourmetsearch

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gourmetsearchapp.domain.NetworkResponse
import com.example.gourmetsearchapp.domain.usecase.GourmetSearchUseCase
import com.example.gourmetsearchapp.ui.settings.SettingsState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class GourmetSearchViewModel @Inject constructor(
    private val gourmetSearchUseCase: GourmetSearchUseCase
) : ViewModel() {
    private val _state = mutableStateOf(GourmetSearchState())
    val state: State<GourmetSearchState> = _state



    // 最初は現在地を取得しない
    init {
        Log.d("api", "request")
        searchGourmet(
            lat = 34.67f, // 緯度
            lng = 135.52f, // 経度
        )
    }

    fun searchGourmet(
        key: String = "3e8644698ca42bf3",
        lat: Float, // 緯度
        lng: Float, // 経度
        range: Int = 5,
        order: Int = 4,
    ) {
        gourmetSearchUseCase(
            key,
            lat, // 緯度
            lng, // 経度
            range,
            order
        ).onEach { result ->
            when (result) {
                // 成功
                is NetworkResponse.Success -> {
                    Log.d("api", "success")
                    _state.value = GourmetSearchState(
                        isLoading = false,
                        gourmets = result.data ?: emptyList(),
                    )
                }
                // 失敗
                is NetworkResponse.Failure -> {
                    Log.d("api", "failure")
                    Log.d("api", result.error!!)
                    _state.value = GourmetSearchState(error = result.error)
                }
                // ローディング
                is NetworkResponse.Loading -> {
                    Log.d("api", "loading")
                    _state.value = GourmetSearchState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}