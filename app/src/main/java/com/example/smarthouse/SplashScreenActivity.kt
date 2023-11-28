package com.example.smarthouse

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.smarthouse.databinding.CreatingPincodeBinding
import com.example.smarthouse.databinding.SplashScreenBinding

class SplashScreenActivity : AppCompatActivity() {

    lateinit var binding: SplashScreenBinding
    lateinit var sharedPref: SharedPreferences
    lateinit var editor: SharedPreferences.Editor
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = SplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Handler().postDelayed({
            var intent = Intent(binding.root.context, AutorizationActivity::class.java)
            startActivity(intent)
            finish()
        }, SPLASH_TIMED_OUT.toLong())
    }

    companion object {
        var SPLASH_TIMED_OUT = 2500
    }
}