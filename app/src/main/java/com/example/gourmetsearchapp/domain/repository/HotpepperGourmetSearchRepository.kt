package com.example.gourmetsearchapp.domain.repository

import com.example.gourmetsearchapp.data.dto.HotpepperGourmetSearchDto

interface HotpepperGourmetSearchRepository {
    suspend fun searchGourmet(
        key: String,
        lat: Float, // 緯度
        lng: Float, // 経度
        range: Int,
        order: Int
    ): HotpepperGourmetSearchDto
}