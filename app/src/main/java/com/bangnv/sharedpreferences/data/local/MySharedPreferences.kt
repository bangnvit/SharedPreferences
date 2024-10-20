package com.bangnv.sharedpreferences.data.local

import android.content.Context

class MySharedPreferences(private val context: Context) {

    companion object {
        private const val MY_SHARED_PREFERENCES = "MY_SHARED_PREFERENCES"
    }

    private val sharedPreferences = context.getSharedPreferences(MY_SHARED_PREFERENCES, Context.MODE_PRIVATE)

    fun putBooleanValue(key: String, value: Boolean) {
        sharedPreferences.edit().putBoolean(key, value).apply()
    }

    fun getBooleanValue(key: String, defaultValue: Boolean = false): Boolean {
        return sharedPreferences.getBoolean(key, defaultValue)
    }

    fun putIntValue(key: String, value: Int) {
        sharedPreferences.edit().putInt(key, value).apply()
    }

    fun getIntValue(key: String, defaultValue: Int = 0): Int {
        return sharedPreferences.getInt(key, defaultValue)
    }

    fun putLongValue(key: String, value: Long) {
        sharedPreferences.edit().putLong(key, value).apply()
    }

    fun getLongValue(key: String, defaultValue: Long = 0): Long {
        return sharedPreferences.getLong(key, defaultValue)
    }

    fun putFloatValue(key: String, value: Float) {
        sharedPreferences.edit().putFloat(key, value).apply()
    }

    fun getFloatValue(key: String, defaultValue: Float = 0.0f): Float {
        return sharedPreferences.getFloat(key, defaultValue)
    }

    fun putStringValue(key: String, value: String) {
        sharedPreferences.edit().putString(key, value).apply()
    }

    fun getStringValue(key: String, defaultValue: String = ""): String {
        return sharedPreferences.getString(key, defaultValue) ?: defaultValue
    }

    fun putStringSetValue(key: String, value: Set<String>) {
        sharedPreferences.edit().putStringSet(key, value).apply()
    }

    fun getStringSetValue(key: String, defaultValue: Set<String> = emptySet()): Set<String> {
        return sharedPreferences.getStringSet(key, defaultValue) ?: defaultValue
    }
}
