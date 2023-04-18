package com.nikhilosatwal.weatherapp

import android.app.Application
import com.nikhilosatwal.weatherapp.di.ApplicationComponent
import com.nikhilosatwal.weatherapp.di.DaggerApplicationComponent

class WeatherApplication : Application() {

    lateinit var applicationComponent : ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerApplicationComponent.builder().build()
    }

}