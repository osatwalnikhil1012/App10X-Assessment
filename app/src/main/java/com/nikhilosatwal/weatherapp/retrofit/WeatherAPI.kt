package com.nikhilosatwal.weatherapp.retrofit

import com.nikhilosatwal.weatherapp.models.WeatherDetail
import com.nikhilosatwal.weatherapp.models.WeatherForecast
import com.nikhilosatwal.weatherapp.utils.Constants.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherAPI {
    @GET("data/2.5/weather?")
    suspend fun getWeatherForLocation(
        @Query("q")
        q: String = "Bengaluru",
        @Query("APPID")
        APPID: String = API_KEY
    ): Response<WeatherDetail>

    @GET("data/2.5/forecast?")
    suspend fun getWeatherForecast(
        @Query("q")
        q: String = "Bengaluru",
        @Query("APPID")
        APPID: String = API_KEY
    ): Response<WeatherForecast>
}