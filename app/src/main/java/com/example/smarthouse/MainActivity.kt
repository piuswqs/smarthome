package com.example.smarthouse

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.enter_adress)
    }

    private fun getClient(){
        var client = createSupabaseClient(
            supabaseUrl = "https://ebmcvljnhjfqunzparux.supabase.com",
            supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6ImVibWN2bGpuaGpmcXVuenBhcnV4Iiwicm9sZSI6ImFub24iLCJpYXQiOjE3MDA3NjYxMjcsImV4cCI6MjAxNjM0MjEyN30.9qct3Lvl2-jf2KSk9M9HSH3dWwvBvsJRcrO5tYw44-w"
        ){
            install(Postgrest)
        }
    }
}