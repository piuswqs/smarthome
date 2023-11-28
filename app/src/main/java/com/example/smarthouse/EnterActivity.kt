package com.example.smarthouse

import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.example.smarthouse.databinding.EnterScreenBinding
import com.example.smarthouse.databinding.RegistrationBinding

class EnterActivity : AppCompatActivity() {
    var pas: MutableList<String>? = null
    var txt: String? = ""

    lateinit var binding: EnterScreenBinding

    lateinit var sharedPref: SharedPreferences
    lateinit var editor: SharedPreferences.Editor
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = EnterScreenBinding.inflate(layoutInflater)
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

            val pincodeTxt = txt.toString()
            val pincodeResult = sharedPref.getString("pincode", null)
            if (pincodeTxt.equals(pincodeResult)) {
                var intent = Intent(binding.root.context, MainActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                txt = ""
                binding.rb1?.setBackgroundDrawable(getDrawable(R.drawable.radio_btn))
                binding.rb2?.setBackgroundDrawable(getDrawable(R.drawable.radio_btn))
                binding.rb3?.setBackgroundDrawable(getDrawable(R.drawable.radio_btn))
                binding.rb4?.setBackgroundDrawable(getDrawable(R.drawable.radio_btn))
                Toast.makeText(binding.root.context, "Пинкод неправильный.\n Попробуйте снова", Toast.LENGTH_SHORT).show()
            }
        }
    }
}