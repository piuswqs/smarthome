package com.example.smarthouse

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.smarthouse.databinding.RegistrationBinding
import com.example.smarthouse.databinding.ScreenAdddeviciBinding
import com.example.smarthouse.databinding.ScreenAddroomsBinding
import com.example.smarthouse.databinding.ScreenDeviceBinding

class ScreenAddDeviceActivity : AppCompatActivity() {
    lateinit var binding: ScreenAdddeviciBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ScreenAdddeviciBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBack.setOnClickListener {
            var intent = Intent(binding.root.context, ScreenAddRoomsActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}