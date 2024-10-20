package com.bangnv.sharedpreferences.data.local

import android.annotation.SuppressLint
import android.content.Context
import com.bangnv.sharedpreferences.model.offline.UserLocal
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory


object DataLocalManager {

    private const val PREF_FIRST_INSTALL = "PREF_FIRST_INSTALL"
    private const val PREF_USER_INFOR = "PREF_USER_INFOR"
    private const val PREF_TOKEN = "PREF_TOKEN"

    @SuppressLint("StaticFieldLeak")
    private lateinit var mySharedPreferences: MySharedPreferences

    // For object (small object)
    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory()) // Helps handle serialization/deserialization for Kotlin classes.
        .build()
    private val jsonAdapter = moshi.adapter(UserLocal::class.java)

    fun initialize(applicationContext: Context) {
        mySharedPreferences = MySharedPreferences(applicationContext.applicationContext)
    }

    var isLoggedIn: Boolean
        get() = mySharedPreferences.getBooleanValue(PREF_FIRST_INSTALL, false)
        set(value) {
            mySharedPreferences.putBooleanValue(PREF_FIRST_INSTALL, value)
        }

    var userLocal: UserLocal?
        get() {
            val json = mySharedPreferences.getStringValue(PREF_USER_INFOR)
            return if (json.isNotEmpty()) {
                jsonAdapter.fromJson(json)
            } else null
        }
        set(value) {
            val json = value?.let { jsonAdapter.toJson(it) } ?: ""
            mySharedPreferences.putStringValue(PREF_USER_INFOR, json)
        }
}
