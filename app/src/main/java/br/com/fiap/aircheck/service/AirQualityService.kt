package br.com.fiap.aircheck.service

import br.com.fiap.aircheck.model.AirQualityResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface AirQualityService {
    @GET("{cidade}/?token=7ca2fefd7ae49f581cb8888cb619c88870d467e9")
    fun getAirQualityByCity(@Path("cidade") cidade: String): Call<AirQualityResponse>
}