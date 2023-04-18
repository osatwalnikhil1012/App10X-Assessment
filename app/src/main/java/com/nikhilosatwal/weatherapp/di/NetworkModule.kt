package com.nikhilosatwal.weatherapp.di

import android.util.Log
import com.nikhilosatwal.weatherapp.retrofit.WeatherAPI
import com.nikhilosatwal.weatherapp.utils.Constants
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofit() : Retrofit {
        return Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideWeatherAPI(retrofit: Retrofit) : WeatherAPI {
        Log.v("Test---->NetworkModule", retrofit.create(WeatherAPI::class.java).toString())
        return retrofit.create(WeatherAPI::class.java)
    }
}