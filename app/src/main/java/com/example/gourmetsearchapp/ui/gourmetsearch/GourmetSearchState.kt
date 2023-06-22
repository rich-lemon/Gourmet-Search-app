package com.example.gourmetsearchapp.ui.gourmetsearch

import com.example.gourmetsearchapp.domain.model.Gourmet

data class GourmetSearchState(
    val isLoading: Boolean = false,
    val gourmets: List<Gourmet> = emptyList(),
    val error: String? = null
)