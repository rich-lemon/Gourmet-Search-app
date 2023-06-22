package com.example.gourmetsearchapp.data

import com.example.gourmetsearchapp.data.dto.HotpepperGourmetSearchDto
import retrofit2.http.GET
import retrofit2.http.Query

interface HotpepperGourmetSearchApi {
    @GET("hotpepper/gourmet/v1")
    suspend fun searchGourmet(
        @Query("key") key: String,
        @Query("lat") lat: Float, // 緯度
        @Query("lng") lng: Float, // 経度
        @Query("range") range: Int,
        @Query("order") order: Int,
        @Query("format") format: String = "json"
    ): HotpepperGourmetSearchDto
}