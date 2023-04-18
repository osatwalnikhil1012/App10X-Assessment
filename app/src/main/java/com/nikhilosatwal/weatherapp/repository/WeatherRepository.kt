package com.nikhilosatwal.weatherapp.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.nikhilosatwal.weatherapp.models.WeatherDetail
import com.nikhilosatwal.weatherapp.models.WeatherForecast
import com.nikhilosatwal.weatherapp.retrofit.WeatherAPI
import javax.inject.Inject

class WeatherRepository @Inject constructor(private val weatherAPI: WeatherAPI) {

    private val _weather = MutableLiveData<WeatherDetail>()
    val weather : LiveData<WeatherDetail>
    get() = _weather

    private val _weatherForecast = MutableLiveData<WeatherForecast>()
    val weatherForecast : LiveData<WeatherForecast>
        get() = _weatherForecast

    suspend fun getWeatherDetails() {
        val result = weatherAPI.getWeatherForLocation()
        Log.v("Test---->Repo", result.toString())
        if (result.isSuccessful && result.body()!=null) {
            _weather.postValue(result.body())
        }
    }
    suspend fun getWeatherForeCast() {
        val result = weatherAPI.getWeatherForecast()
        Log.v("Test---->Repo", result.toString())
        if (result.isSuccessful && result.body()!=null) {
            _weatherForecast.postValue(result.body())
        }
    }
}