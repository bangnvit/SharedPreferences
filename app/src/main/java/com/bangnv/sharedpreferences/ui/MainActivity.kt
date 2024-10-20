package com.bangnv.sharedpreferences.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bangnv.sharedpreferences.data.local.DataLocalManager
import com.bangnv.sharedpreferences.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        applyWindowInsets()

        setupUI()
        setupCLickListener()
    }

    private fun setupUI() {
        binding.tvTextDisplay.text = DataLocalManager.userLocal.toString()
    }

    private fun setupCLickListener() {
        binding.btnLogout.setOnClickListener {
            DataLocalManager.userLocal = null
            DataLocalManager.isLoggedIn = false
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }

    private fun applyWindowInsets() {
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}