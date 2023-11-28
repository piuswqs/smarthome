package com.example.smarthouse

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.smarthouse.databinding.MainScreenBinding
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest

class MainActivity : AppCompatActivity() {
    lateinit var binding: MainScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.settings.setOnClickListener {
            var intent = Intent(binding.root.context, ProfileActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun getClient() {
        var client = createSupabaseClient(
            supabaseUrl = "https://ebmcvljnhjfqunzparux.supabase.com",
            supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6ImVibWN2bGpuaGpmcXVuenBhcnV4Iiwicm9sZSI6ImFub24iLCJpYXQiOjE3MDA3NjYxMjcsImV4cCI6MjAxNjM0MjEyN30.9qct3Lvl2-jf2KSk9M9HSH3dWwvBvsJRcrO5tYw44-w"
        ) {
            install(Postgrest)
        }
    }
}