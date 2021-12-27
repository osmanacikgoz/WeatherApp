package com.osmanacikgoz.weatherapp.base.extensions

import android.app.Activity
import android.widget.Toast
import java.util.*

fun Activity.showToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}
