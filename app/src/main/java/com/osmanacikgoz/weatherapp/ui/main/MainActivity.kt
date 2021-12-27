package com.osmanacikgoz.weatherapp.ui.main

import android.Manifest
import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Intent
import android.location.Location
import android.location.LocationManager
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.*
import androidx.databinding.DataBindingUtil
import com.karumi.dexter.Dexter
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionDeniedResponse
import com.karumi.dexter.listener.PermissionGrantedResponse
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.single.PermissionListener
import com.osmanacikgoz.weatherapp.R
import com.osmanacikgoz.weatherapp.base.extensions.showToast
import com.osmanacikgoz.weatherapp.databinding.ActivityMainBinding
import com.osmanacikgoz.weatherapp.ui.search.SearchActivity
import org.koin.android.viewmodel.ext.android.viewModel
import java.util.*


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val localizedName = intent.getStringExtra("localizedName")
        binding.tvWeatherText.text = localizedName

        initUI()
    }

    private fun initUI() {
        setClickListeners()
        requestLocationPermissions()
        observeGeoPositionLiveData()
        observeCurrentConditionsLiveData()
        oneDailyForecastLiveData()
        changeBackground()
    }

    private fun setClickListeners() {
        with(binding) {
            ivSearch.setOnClickListener {
                navigateSearchPage()
            }
        }
    }

    private fun observeGeoPositionLiveData() {
        viewModel.geoPositionLiveData.observe(this) { geoPosition ->
            geoPosition?.let {
                it.key?.let { key->
                    getCurrentConditions(key)
                }
                binding.tvCityName.text= it.localizedName
            }
        }
    }

    private fun getCurrentConditions(locationKey: String) {
        viewModel.getCurrentConditions(locationKey)
        viewModel.getOneDailyForecast(locationKey)
    }

    private fun observeCurrentConditionsLiveData() {
        viewModel.currentConditionsLiveData.observe(this) { currentConditions ->
            with(binding) {
                currentConditions?.let {
                    this.tvTemperature.text = it[0].temperature?.metric?.value.toString()
                    this.tvWeatherText.text = it[0].weatherText.toString()
                }
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun oneDailyForecastLiveData() {
        viewModel.oneDailyForecastLiveData.observe(this) { oneDailyForecast ->
            with(binding) {
                oneDailyForecast?.let {
                    this.tvDayAndNight.text =
                        it.dailyForecasts?.get(0)?.temperature?.maximum?.value.toString() + "/" +
                                it.dailyForecasts?.get(0)?.temperature?.minimum?.value.toString()
                }
            }
        }
    }

    private fun changeBackground() {
        val constraint = binding.background
        val calendar: Calendar = Calendar.getInstance()
        when (calendar.get(Calendar.HOUR_OF_DAY)) {
            in 8..18 -> {
                constraint.setBackgroundResource(R.drawable.daytime)
            }
            in 18..24 -> {
                constraint.setBackgroundResource(R.drawable.night)
            }
            in 0..8 -> {
                constraint.setBackgroundResource(R.drawable.night)
            }

        }
    }

    @SuppressLint("MissingPermission")
    fun getLocation() {
        val locationManager = getSystemService(LOCATION_SERVICE) as LocationManager

        val currentLocation = locationManager.getLastKnownLocation(
            LocationManager.GPS_PROVIDER
        )

        getGeoPositionByCurrentLocation(currentLocation)
    }

    private fun getGeoPositionByCurrentLocation(currentLocation: Location?) {
        currentLocation?.let {
            val latLang = "${it.latitude},${it.longitude}"
            viewModel.getGeoPosition(latLang)
        }
    }

    private fun navigateSearchPage() {
        val intent = Intent(this@MainActivity, SearchActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun requestLocationPermissions() {
        Dexter.withContext(this)
            .withPermission(
                Manifest.permission.ACCESS_FINE_LOCATION
            ).withListener(object : PermissionListener {
                override fun onPermissionGranted(p0: PermissionGrantedResponse?) {
                    getLocation()
                }

                override fun onPermissionDenied(p0: PermissionDeniedResponse?) {
                    showToast(getString(R.string.permision))
                    showSettingsDialog()
                }

                override fun onPermissionRationaleShouldBeShown(
                    p0: PermissionRequest?,
                    token: PermissionToken?
                ) {
                    token?.continuePermissionRequest()

                }
            }).check()
    }

    private fun showSettingsDialog() {
        val builder: AlertDialog.Builder = AlertDialog.Builder(this@MainActivity)
        builder.setTitle(getString(R.string.locaiton_permision))
        builder.setMessage(getString(R.string.location_permision_text))
        builder.setPositiveButton(
            getString(R.string.go_settings)
        ) { dialog, which ->
            val intent = Intent(Settings.ACTION_LOCALE_SETTINGS)
            val uri: Uri = Uri.fromParts("package", packageName, null)
            intent.data = uri
            startActivityForResult(intent, 111)
        }
        builder.setCancelable(false)
        builder.show()
    }

}