package com.example.gourmetsearchapp.data.dto

import com.example.gourmetsearchapp.domain.model.Gourmet
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class HotpepperGourmetSearchDto(
    val results: Results?
)

fun HotpepperGourmetSearchDto.toGourmets(): List<Gourmet> {
    return results!!.shop!!.map {
        Gourmet(
            name = it!!.name!!, // 掲載店名
            logo_image = it.logoImage, // ロゴ画像
            address = it.address!!, // 住所
            station_name = it.stationName, // 最寄駅名
            mobile_l = it.photo!!.mobile?.l, // 携帯向け/店舗トップ写真(大）画像URL
            mobile_s = it.photo!!.mobile?.s, // 携帯向け/店舗トップ写真(小）画像URL
            open = it.open, // 営業時間
            close = it.close, // 定休日
        )
    }
}