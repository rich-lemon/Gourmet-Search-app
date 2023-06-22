package com.example.gourmetsearchapp.domain.usecase

import com.example.gourmetsearchapp.data.dto.toGourmets
import com.example.gourmetsearchapp.domain.NetworkResponse
import com.example.gourmetsearchapp.domain.model.Gourmet
import com.example.gourmetsearchapp.domain.repository.HotpepperGourmetSearchRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GourmetSearchUseCase @Inject constructor(
    private val repository: HotpepperGourmetSearchRepository
) {
    operator fun invoke(
        key: String,
        lat: Float, // 緯度
        lng: Float, // 経度
        range: Int,
        order: Int
    ): Flow<NetworkResponse<List<Gourmet>>> = flow {
        try {
            emit(NetworkResponse.Loading<List<Gourmet>>())
            val gourmets = repository.searchGourmet(
                key,
                lat, // 緯度
                lng, // 経度
                range,
                order
            ).toGourmets()
            emit(NetworkResponse.Success<List<Gourmet>>(gourmets))
        } catch (e: Exception) {
            emit(NetworkResponse.Failure<List<Gourmet>>(e.message.toString()))
        }
    }
}