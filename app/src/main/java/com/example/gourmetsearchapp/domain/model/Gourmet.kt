package com.example.gourmetsearchapp.domain.model

data class Gourmet(
    val name: String, // 掲載店名
    val logo_image: String?, // ロゴ画像
    val address: String, // 住所
    val station_name: String?, // 最寄駅名
    val mobile_l: String?, // 携帯向け/店舗トップ写真(大）画像URL
    val mobile_s: String?, // 携帯向け/店舗トップ写真(小）画像URL
    val open: String?, // 営業時間
    val close: String?, // 定休日
)