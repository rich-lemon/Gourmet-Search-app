package com.example.gourmetsearchapp.data

import com.example.gourmetsearchapp.data.dto.HotpepperGourmetSearchDto
import com.example.gourmetsearchapp.domain.repository.HotpepperGourmetSearchRepository
import javax.inject.Inject

class HotpepperGourmetSearchRepositoryImpl @Inject constructor(
    private val api: HotpepperGourmetSearchApi,
) : HotpepperGourmetSearchRepository {
    override suspend fun searchGourmet(
        key: String,
        lat: Float, // 緯度
        lng: Float, // 経度
        range: Int,
        order: Int
    ): HotpepperGourmetSearchDto {
        return api.searchGourmet(
            key,
            lat, // 緯度
            lng, // 経度
            range,
            order
        )
    }
}