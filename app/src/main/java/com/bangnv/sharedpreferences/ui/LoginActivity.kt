package com.bangnv.sharedpreferences.ui

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bangnv.sharedpreferences.R
import com.bangnv.sharedpreferences.data.local.DataLocalManager
import com.bangnv.sharedpreferences.databinding.ActivityLoginBinding
import com.bangnv.sharedpreferences.model.offline.UserLocal

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        applyWindowInsets()

        setupClickListener()
    }

    private fun setupClickListener() {
        binding.btnLogin.setOnClickListener {
            if (validateInputs()) {
                val email = binding.edtEmail.text.toString().trim()
                val userEx = UserLocal(email) // default address by primary constructor
                DataLocalManager.userLocal = userEx
                DataLocalManager.isLoggedIn = true
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }
        }
    }

    private fun validateInputs(): Boolean {
        val email = binding.edtEmail.text.toString().trim()
        val password = binding.edtPassword.text.toString().trim()

        if (email.isEmpty()) {
            binding.edtEmail.error = getString(R.string.str_email_not_empty)
            binding.edtEmail.requestFocus()
            return false
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            binding.edtEmail.error = getString(R.string.str_email_not_true_format)
            binding.edtEmail.requestFocus()
            return false
        }

        if (password.isEmpty()) {
            binding.edtPassword.error = getString(R.string.str_password_not_empty)
            binding.edtPassword.requestFocus()
            return false
        }
        return true
    }

    private fun applyWindowInsets() {
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}