package br.com.fiap.aircheck.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitFactory {
    private val URL = "https://api.waqi.info/feed/"

    private val retrofitFactory = Retrofit
        .Builder()
        .baseUrl(URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getAirQualityService(): AirQualityService {
        return retrofitFactory.create(AirQualityService::class.java)
    }
}