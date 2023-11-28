package com.example.smarthouse

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.smarthouse.databinding.EnterAdressBinding
import com.example.smarthouse.databinding.ScreenAddroomsBinding

class ScreenAddRoomsActivity : AppCompatActivity() {
    lateinit var binding: ScreenAddroomsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ScreenAddroomsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBack.setOnClickListener {
            val intent = Intent(binding.root.context, EnterAddressActivity::class.java)
            startActivity(intent)
            finish()
        }
        binding.btnSave.setOnClickListener{
            var intent = Intent(binding.root.context, ScreenAddDeviceActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}