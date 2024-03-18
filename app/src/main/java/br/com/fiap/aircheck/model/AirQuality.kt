package br.com.fiap.aircheck.model

import com.google.gson.annotations.SerializedName

data class AirQualityResponse(
    val data: AirQualityData
)

data class AirQualityData(
    val aqi: Int,
//    @SerializedName("t") val temp: Int = 0
)

