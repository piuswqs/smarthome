package com.example.smarthouse

import android.annotation.SuppressLint
import android.content.Intent
import android.content.SharedPreferences
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
    var txt: String? = ""

    lateinit var binding: CreatingPincodeBinding
    lateinit var sharedPref: SharedPreferences
    lateinit var editor: SharedPreferences.Editor

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        txt = ""
        binding = CreatingPincodeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPref = getSharedPreferences("myPref", MODE_PRIVATE)
        editor = sharedPref.edit()

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

    fun onClick(view: View?) {
        val btn = view as TextView
        pas?.add(btn.text.toString())
        txt += btn.text.toString()

        if (txt?.length == 1) {
            binding.rb1?.setBackgroundDrawable(getDrawable(R.drawable.radio_btn_white))
        }
        if (txt?.length == 2) {
            binding.rb2?.setBackgroundDrawable(getDrawable(R.drawable.radio_btn_white))
        }
        if (txt?.length == 3) {
            binding.rb3?.setBackgroundDrawable(getDrawable(R.drawable.radio_btn_white))
        }
        if (txt?.length == 4) {
            binding.rb4?.setBackgroundDrawable(getDrawable(R.drawable.radio_btn_white))

            binding.apply {
                val pincodeTxt = txt.toString()
                val hasVisited = true
                editor.apply{
                    putString("pincode", pincodeTxt)
                    putBoolean("hasvisited_CreatingPinCode", hasVisited)
                    apply()
                }
            }
            val intent = Intent(binding.root.context, EnterAddressActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
