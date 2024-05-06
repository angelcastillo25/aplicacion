package com.example.androidmaster.firstApp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.*
import com.example.androidmaster.R

class FirstAppActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_app)
        val btnStart = findViewById<AppCompatButton>(R.id.AppButton)
        val editText = findViewById<AppCompatEditText>(R.id.textview1)
        btnStart.setOnClickListener {
            val name = editText.text.toString()
            if (name.isNotEmpty()) {
                val intent = Intent(this,resultActivity::class.java)
                intent.putExtra("EXTRA_NAME", name)
                startActivity(intent)
            }
        }
    }
}