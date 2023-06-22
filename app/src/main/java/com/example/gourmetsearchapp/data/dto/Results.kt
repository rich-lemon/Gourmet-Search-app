package com.example.gourmetsearchapp.data.dto


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Results(
    @Json(name = "api_version")
    val apiVersion: String?,
    @Json(name = "results_available")
    val resultsAvailable: Int?,
    @Json(name = "results_returned")
    val resultsReturned: String?,
    @Json(name = "results_start")
    val resultsStart: Int?,
    val shop: List<Shop?>?
)