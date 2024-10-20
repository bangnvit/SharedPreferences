package com.bangnv.sharedpreferences.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bangnv.sharedpreferences.data.local.DataLocalManager
import com.bangnv.sharedpreferences.databinding.ActivityMySplashBinding

@SuppressLint("CustomSplashScreen")
class MySplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        applyWindowInsets()

        startAppFlow()
    }

    private fun startAppFlow() {
        val splashDuration = 1500L
        window.decorView.postDelayed({
            if (!DataLocalManager.isLoggedIn) {
                startActivity(Intent(this, LoginActivity::class.java))!!
            } else {
                startActivity(Intent(this, MainActivity::class.java))
            }
            finish()
        }, splashDuration)
    }

    private fun applyWindowInsets() {
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}