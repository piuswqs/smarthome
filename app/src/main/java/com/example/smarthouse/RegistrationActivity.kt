package com.example.smarthouse

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.smarthouse.Managers.UsersManager
import com.example.smarthouse.databinding.RegistrationBinding
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.gotrue.GoTrue
import io.github.jan.supabase.gotrue.gotrue
import io.github.jan.supabase.gotrue.providers.builtin.Email
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.postgrest.postgrest
import io.github.jan.supabase.postgrest.query.Returning
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

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

                    MainScope().launch {
                        val usersManager = UsersManager()
                        usersManager.addNewUser(binding.root.context, txtEditEmail, txtEditName, txtEditPassword)
                    }

                    if (!hasVisited) {
                        var intent =
                            Intent(binding.root.context, CreatingPinCodeClass::class.java)
                        startActivity(intent)
                        finish()
                    } else {
                        var intent = Intent(binding.root.context, EnterActivity::class.java)
                        startActivity(intent)
                        finish()
                    }
                } else {
                    binding.editEmail.text.clear()
                    Toast.makeText(binding.root.context, "Введите почту", Toast.LENGTH_SHORT)
                        .show()
                }
            } else {
                Toast.makeText(binding.root.context, "Заполните поля!", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }


}