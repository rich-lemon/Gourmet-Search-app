package com.example.gourmetsearchapp.data.dto


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LargeServiceArea(
    val code: String?,
    val name: String?
)