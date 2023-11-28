package com.example.smarthouse

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.example.smarthouse.databinding.AutorizationBinding
import com.example.smarthouse.databinding.RegistrationBinding

class AutorizationActivity : AppCompatActivity() {
    lateinit var binding: AutorizationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = AutorizationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRegistrationAuth.setOnClickListener{
            var intent = Intent(binding.root.context, RegistrationActivity::class.java)
            startActivity(intent)
            finish()
        }
        binding.btnEnterAuth.setOnClickListener {
            val txtEditEmail = binding.editEmail.text.toString()
            val txtEditPassword = binding.editPassword.text.toString()

            if (txtEditEmail.isNotEmpty() && txtEditPassword.isNullOrEmpty()){
                if (android.util.Patterns.EMAIL_ADDRESS.matcher(txtEditEmail).matches()){

                    var intent = Intent(binding.root.context, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                }
                else{
                    binding.editEmail.text.clear()
                    Toast.makeText(binding.root.context, "Введите почту", Toast.LENGTH_SHORT).show()
                }
            }
            else{
                Toast.makeText(binding.root.context, "Поле пусто", Toast.LENGTH_SHORT).show()
            }
        }
    }
}