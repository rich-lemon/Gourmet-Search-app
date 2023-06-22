package com.example.gourmetsearchapp.di

import com.example.gourmetsearchapp.data.HotpepperGourmetSearchApi
import com.example.gourmetsearchapp.data.HotpepperGourmetSearchRepositoryImpl
import com.example.gourmetsearchapp.domain.repository.HotpepperGourmetSearchRepository
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideHotpepperGourmetSearchAPI(): HotpepperGourmetSearchApi {
        return Retrofit.Builder()
            .baseUrl("https://webservice.recruit.co.jp")
            .addConverterFactory(
                MoshiConverterFactory.create(
                    Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
                )
            ).build().create(HotpepperGourmetSearchApi::class.java)
    }

    @Provides
    @Singleton
    fun provideHotpepperGourmetSearchRepository(api: HotpepperGourmetSearchApi): HotpepperGourmetSearchRepository {
        return HotpepperGourmetSearchRepositoryImpl(api)
    }
}