package com.nikhilosatwal.weatherapp.models

data class list(
    val dt_txt: String,
    val main: Main,
    val weather: List<Weather>
)