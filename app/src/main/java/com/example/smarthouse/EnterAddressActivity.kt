package com.example.smarthouse

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.smarthouse.databinding.CreatingPincodeBinding
import com.example.smarthouse.databinding.EnterAdressBinding

class EnterAddressActivity : AppCompatActivity() {

    lateinit var binding: EnterAdressBinding
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = EnterAdressBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSave.setOnClickListener{
            var intent = Intent(binding.root.context, ScreenAddRoomsActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}