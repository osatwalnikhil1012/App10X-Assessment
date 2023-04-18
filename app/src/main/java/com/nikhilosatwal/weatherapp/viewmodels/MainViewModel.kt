package com.nikhilosatwal.weatherapp.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nikhilosatwal.weatherapp.models.WeatherDetail
import com.nikhilosatwal.weatherapp.models.WeatherForecast
import com.nikhilosatwal.weatherapp.repository.WeatherRepository
import kotlinx.coroutines.launch

class MainViewModel(private val repository: WeatherRepository) : ViewModel() {

    val weatherLiveData : LiveData<WeatherDetail>
    get() = repository.weather

    val weatherForecastLiveData : LiveData<WeatherForecast>
        get() = repository.weatherForecast

    init {
        viewModelScope.launch {
            repository.getWeatherDetails()
            repository.getWeatherForeCast()
        }
    }
}