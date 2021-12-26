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

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        initUI()
    }


    private fun initUI() {
        setClickListeners()
        requestLocationPermissions()
        observeGeoPositionLiveData()
        observeCurrentConditionsLiveData()
        oneDailyForecastLiveData()
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
            geoPosition?.key?.let {
                getCurrentConditions(it)
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
                    this.tvTemperature.text = it[0].temperature.toString()
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
                        it.dailyForecasts?.get(0)?.temperature?.maximum.toString() + "/" +
                                it.dailyForecasts?.get(0)?.temperature?.minimum.toString()
                }
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
                    showToast("İzin Reddedildi.")
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
        builder.setTitle("Konum İzini Gerekiyor")
        builder.setMessage("Uygulamayı kullanabilmeniz için konumunuza ihtiyaç duymaktadır, İzinler -> Konuma gidip izin vermeniz gerekmektedir.")
        builder.setPositiveButton(
            "Ayarlara git"
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