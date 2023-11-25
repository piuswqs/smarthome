package com.example.smarthouse

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.smarthouse.databinding.ActivityMainBinding

class CreatingPinCodeClass: AppCompatActivity() {
    var txt: TextView? = null
    var pas: MutableList<String>? = null

    lateinit var binding: ActivityMainBinding

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.creating_pincode)

        binding = ActivityMainBinding.inflate(layoutInflater)
        var sharedPref = getSharedPreferences("myPref", MODE_PRIVATE)
        var editor = sharedPref.edit()

        

        val btn1 = findViewById<TextView>(R.id.btnCPnubmer1)
        val btn2 = findViewById<TextView>(R.id.btnCPnubmer2)
        val btn3 = findViewById<TextView>(R.id.btnCPnubmer3)
        val btn4 = findViewById<TextView>(R.id.btnCPnubmer4)
        val btn5= findViewById<TextView>(R.id.btnCPnubmer5)
        val btn6 = findViewById<TextView>(R.id.btnCPnubmer6)
        val btn7= findViewById<TextView>(R.id.btnCPnubmer7)
        val btn8= findViewById<TextView>(R.id.btnCPnubmer8)
        val btn9 = findViewById<TextView>(R.id.btnCPnubmer9)
    }
    fun onClick(view: View?){
        val button = view as Button
        pas?.add(button.text.toString())
        txt?.text = pas.toString()
        if (pas!!.size == 1) {

        }
        if (pas!!.size == 2) {

        }
        if (pas!!.size == 3) {

        }
        if (pas!!.size == 4) {

        }
    }
}