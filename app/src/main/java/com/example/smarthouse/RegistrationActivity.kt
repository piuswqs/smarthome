package com.example.smarthouse

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.smarthouse.databinding.RegistrationBinding
import com.example.smarthouse.databinding.SplashScreenBinding
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest


class RegistrationActivity : AppCompatActivity() {

    lateinit var binding: RegistrationBinding
    lateinit var sharedPref: SharedPreferences
    lateinit var editor: SharedPreferences.Editor
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = RegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPref = getSharedPreferences("myPref", MODE_PRIVATE)
        editor = sharedPref.edit()

        binding.btnAutorizationReg.setOnClickListener {
            var intent = Intent(binding.root.context, AutorizationActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.btnRegistrationReg.setOnClickListener {
            val txtEditName = binding.editName.text.toString()
            val txtEditEmail = binding.editEmail.text.toString()
            val txtEditPassword = binding.editPassword.text.toString()

            if (!(txtEditEmail.isNullOrEmpty() && txtEditName.isNullOrEmpty() && txtEditPassword.isNullOrEmpty())) {
                if (android.util.Patterns.EMAIL_ADDRESS.matcher(txtEditEmail).matches()) {
                    val hasVisited = sharedPref.getBoolean("hasvisited_CreatingPinCode", false)
                    if (!hasVisited) {
                        var intent = Intent(binding.root.context, CreatingPinCodeClass::class.java)
                        startActivity(intent)
                        finish()
                    } else {
                        var intent = Intent(binding.root.context, EnterActivity::class.java)
                        startActivity(intent)
                        finish()
                    }
                } else {
                    binding.editEmail.text.clear()
                    Toast.makeText(binding.root.context, "Введите почту", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(binding.root.context, "Заполните поля!", Toast.LENGTH_SHORT).show()
            }
        }

        var client = createSupabaseClient(
            supabaseUrl = "https://ebmcvljnhjfqunzparux.supabase.com",
            supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6ImVibWN2bGpuaGpmcXVuenBhcnV4Iiwicm9sZSI6ImFub24iLCJpYXQiOjE3MDA3NjYxMjcsImV4cCI6MjAxNjM0MjEyN30.9qct3Lvl2-jf2KSk9M9HSH3dWwvBvsJRcrO5tYw44-w"
        ) {
            install(Postgrest)
        }
    }
}