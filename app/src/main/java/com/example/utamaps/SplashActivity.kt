package com.example.utamaps

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startActivity(Intent(this,MenuPrincipal::class.java))
        finish()

    }

    override fun onDestroy() {
        super.onDestroy()
    }
}