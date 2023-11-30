package com.example.smarthouse.Managers

import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.gotrue.GoTrue
import io.github.jan.supabase.postgrest.Postgrest

object SupabaseManager {
    private var supabaseClient: SupabaseClient? = null
    fun getSupabaseClient(): SupabaseClient {
        if (supabaseClient == null) {
            val supabaseUrl = "https://ebmcvljnhjfqunzparux.supabase.co"
            val supabaseKey =
                "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6ImVibWN2bGpuaGpmcXVuenBhcnV4Iiwicm9sZSI6ImFub24iLCJpYXQiOjE3MDA3NjYxMjcsImV4cCI6MjAxNjM0MjEyN30.9qct3Lvl2-jf2KSk9M9HSH3dWwvBvsJRcrO5tYw44-w"
            supabaseClient = createSupabaseClient(supabaseUrl, supabaseKey) {
                install(GoTrue)
                install(Postgrest)
            }
        }
        return supabaseClient!!
    }
}