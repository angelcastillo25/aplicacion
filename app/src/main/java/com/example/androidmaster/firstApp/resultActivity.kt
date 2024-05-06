package com.example.androidmaster.firstApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatTextView
import com.example.androidmaster.R

class resultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        val textView = findViewById<AppCompatTextView>(R.id.text1)
        val name:String = intent.extras?.getString("EXTRA_NAME").orEmpty()
        textView.text = "hola ${name}"
    }
}