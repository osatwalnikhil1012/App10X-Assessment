package com.nikhilosatwal.weatherapp.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.nikhilosatwal.weatherapp.repository.WeatherRepository
import javax.inject.Inject

class MainViewModelFactory @Inject constructor(private val repository: WeatherRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(repository) as T
    }
}