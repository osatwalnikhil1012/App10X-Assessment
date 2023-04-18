package com.nikhilosatwal.weatherapp.di

import com.nikhilosatwal.weatherapp.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface ApplicationComponent {

    fun inject(mainActivity: MainActivity)

}