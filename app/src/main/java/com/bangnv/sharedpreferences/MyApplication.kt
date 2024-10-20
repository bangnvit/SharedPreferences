package com.bangnv.sharedpreferences

import android.app.Application
import com.bangnv.sharedpreferences.data.local.DataLocalManager

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        // initialize DataLocalManager
        DataLocalManager.initialize(applicationContext)
    }
}