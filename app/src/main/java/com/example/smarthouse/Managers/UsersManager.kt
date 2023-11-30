package com.example.smarthouse.Managers

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.example.smarthouse.RegistrationActivity
import com.example.smarthouse.User
import io.github.jan.supabase.gotrue.gotrue
import io.github.jan.supabase.gotrue.providers.builtin.Email
import io.github.jan.supabase.postgrest.postgrest
import io.github.jan.supabase.postgrest.query.Returning

class UsersManager {
    suspend fun addNewUser(
        activity: Context, email_: String, username_: String, password_: String
    ) {
        try {
            val user_ = SupabaseManager.getSupabaseClient().gotrue.signUpWith(
                Email
            ) {
                email = email_
                password = password_
            }
            SupabaseManager.getSupabaseClient().gotrue.loginWith(Email) {
                email = email_
                password = password_
            }
            val get_user = SupabaseManager.getSupabaseClient().gotrue.retrieveUserForCurrentSession(
                updateSession = true
            )
            val user =
                User(
                    id = get_user.id,
                    email = email_,
                    name = username_,
                    password = password_,
                    address = "defrgthyjmkhgfdsazZSWDERFGTHYUJIK"
                )
            println(user.toString());
            SupabaseManager.getSupabaseClient().postgrest["user"].insert(
                user,
                returning = Returning.REPRESENTATION
            )
        } catch (e: Exception) {
            activity.run {
                Toast.makeText(
                    activity.applicationContext,
                    "Ошибка: ${e.message}",
                    Toast.LENGTH_SHORT
                ).show()
                Log.e("aaa", e.message.toString())
            }
        }
    }
}