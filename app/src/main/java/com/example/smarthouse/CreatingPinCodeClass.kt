package com.example.smarthouse

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.smarthouse.databinding.CreatingPincodeBinding

class CreatingPinCodeClass : AppCompatActivity() {

    var pas: MutableList<String>? = null
    var txt: String? = null

    lateinit var binding: CreatingPincodeBinding

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = CreatingPincodeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var sharedPref = getSharedPreferences("myPref", MODE_PRIVATE)
        var editor = sharedPref.edit()

        listOf(
            binding.btnCPnubmer1,
            binding.btnCPnubmer2,
            binding.btnCPnubmer3,
            binding.btnCPnubmer4,
            binding.btnCPnubmer5,
            binding.btnCPnubmer6,
            binding.btnCPnubmer7,
            binding.btnCPnubmer8,
            binding.btnCPnubmer9
        ).forEach {
            it.setOnClickListener(::onClick)
        }

    }
// попробовать через свитч кейс
    fun onClick(view: View?) {
        val btn = view as TextView
        pas?.add(btn.text.toString())
        txt += btn.text.toString()

        if (pas?.size == 1) {
            binding.rb1?.setBackgroundColor(Color.WHITE)
            Toast.makeText(applicationContext, txt.toString(), Toast.LENGTH_SHORT).show()
        }
        if (pas?.size == 2) {
            binding.rb2?.setBackgroundColor(Color.WHITE)
            Toast.makeText(applicationContext, txt.toString(), Toast.LENGTH_SHORT).show()
        }
        if (pas?.size == 3) {
            binding.rb3?.setBackgroundColor(Color.WHITE)
            Toast.makeText(applicationContext, btn.text.toString(), Toast.LENGTH_SHORT).show()
        }
        if (pas?.size == 4) {
            binding.rb4?.setBackgroundColor(Color.WHITE)
            Toast.makeText(applicationContext, btn.text.toString(), Toast.LENGTH_SHORT).show()
            val intent = Intent(applicationContext, EnterAddressActivity::class.java)
            startActivity(intent)
        }
    }
}