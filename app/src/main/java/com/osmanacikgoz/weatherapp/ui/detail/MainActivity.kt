package com.osmanacikgoz.weatherapp.ui.detail

import android.Manifest
import android.app.AlertDialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.karumi.dexter.Dexter
import com.karumi.dexter.MultiplePermissionsReport
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.multi.MultiplePermissionsListener
import com.osmanacikgoz.weatherapp.R
import com.osmanacikgoz.weatherapp.databinding.ActivityMainBinding
import com.osmanacikgoz.weatherapp.ui.search.SearchActivity
import com.osmanacikgoz.weatherapp.util.Utils
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModelDetail: DetailViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUserPermissions()
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val locationKey = intent.getStringExtra("locationKey")

        locationKey?.let {
            viewModelDetail.weatherDetail(it)
        }
        weatherCityDetail(0)
        with(binding) {
            ivSearch.setOnClickListener {
                startActivity(Intent(this@MainActivity, SearchActivity::class.java))
            }
        }
    }

    private fun weatherCityDetail(position: Int) {
        viewModelDetail.detailLiveData.observe(this, { cityDetail ->
            cityDetail?.let {
                it[position].apply {
                    binding.tvWeatherText.text = this.headline?.text
                    binding.tvTemperature.text =
                        this.dailyForecasts?.get(0)?.temperature?.minimum?.value.toString()
                    binding.tvRealTemperature.text =
                        this.dailyForecasts?.get(0)?.realFeelTemperature?.minimum?.value.toString()
                    binding.tvWind.text =
                        this.dailyForecasts?.get(0)?.day?.wind?.speed?.value.toString()
                }
            }
        })
    }

    fun setUserPermissions() {
        Dexter.withContext(this)
            .withPermissions(
                Manifest.permission.ACCESS_FINE_LOCATION
            ).withListener(object : MultiplePermissionsListener {
                override fun onPermissionsChecked(report: MultiplePermissionsReport) {
                    if (report.areAllPermissionsGranted()) {
                        getLocation()
                    }
                    if (report.deniedPermissionResponses.size != 0 && !report.isAnyPermissionPermanentlyDenied) {
                        setUserPermissions()
                    }
                    if (report.isAnyPermissionPermanentlyDenied) {
                        showSettingsDialog()
                    }
                }

                override fun onPermissionRationaleShouldBeShown(
                    permissions: MutableList<com.karumi.dexter.listener.PermissionRequest>?,
                    token: PermissionToken?
                ) {
                    token?.continuePermissionRequest()
                }
            }).withErrorListener {
                Toast.makeText(
                    baseContext,
                    "Hata! ",
                    Toast.LENGTH_SHORT
                ).show()
            }
            .onSameThread()
            .check()
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

    fun getLocation() {
        Utils.getLocation(this) {
            it?.adminArea
        }
    }
}