package com.example.smarthouse

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.smarthouse.databinding.ProfileBinding

class ProfileActivity : AppCompatActivity() {
    lateinit var binding: ProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnGoOut.setOnClickListener{
            var intent = Intent(binding.root.context, AutorizationActivity::class.java)
            startActivity(intent)
            finish()
        }
        binding.btnBack.setOnClickListener {
            var intent = Intent(binding.root.context, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
        binding.btnSave.setOnClickListener{
            val editName = binding.editName.text.toString()
            val editEmail = binding.editEmail.text.toString()
            val editAddress = binding.editAddress.text.toString()

            if (!(editName.isNullOrEmpty() && editEmail.isNullOrEmpty() && editAddress.isNullOrEmpty())){
                var intent = Intent(binding.root.context, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
}