package com.nikhilosatwal.weatherapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.nikhilosatwal.weatherapp.viewmodels.MainViewModel
import com.nikhilosatwal.weatherapp.viewmodels.MainViewModelFactory
import javax.inject.Inject
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel: MainViewModel

    @Inject
    lateinit var mainViewModelFactory: MainViewModelFactory

    private val cityTemp: TextView
        get() = findViewById(R.id.city_temp)

    private val cityName: TextView
        get() = findViewById(R.id.city_name)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (application as WeatherApplication).applicationComponent.inject(this)
        mainViewModel = ViewModelProvider(this, mainViewModelFactory)[MainViewModel::class.java]

        mainViewModel.weatherLiveData.observe(this) {
            val temp = kelvinToCelsius(it.main.temp).toString() + "\u00B0"
            cityTemp.text = temp
            cityName.text = it.name
            showBottomSheetDialog()
        }
        mainViewModel.weatherForecastLiveData.observe(this) {
            Log.v("Test---->Activity", it.list.joinToString { x -> x.dt_txt + "\n\n" })
        }
    }

    fun kelvinToCelsius(temp : Double) : Int {
        var x = temp
        x -= 273.15
        return x.roundToInt()
    }

    private fun showBottomSheetDialog() {

        val dialog = BottomSheetDialog(this)

        dialog.setContentView(R.layout.bottom_sheet_dialog_layout)

        dialog.show()
    }
}