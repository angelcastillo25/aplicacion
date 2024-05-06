package com.example.androidmaster

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton
import com.example.androidmaster.ImcCalculator.ImcCalcualtorActivity
import com.example.androidmaster.firstApp.FirstAppActivity
import com.example.androidmaster.todoApp.TodoActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        val btnSaludar = findViewById<AppCompatButton>(R.id.btnSaludar)
        btnSaludar.setOnClickListener { navigateToSaludar() }
        val btnImc = findViewById<AppCompatButton>(R.id.btnIMCApp)
        btnImc.setOnClickListener { navigateToImcApp() }
        val TODOapp = findViewById<AppCompatButton>(R.id.btnTODOApp)
        TODOapp.setOnClickListener { navigateToTODOapp() }
    }

    private fun navigateToTODOapp() {
        val intent = Intent(this, TodoActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToImcApp() {
        val intent = Intent(this, ImcCalcualtorActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToSaludar(){
        val intent = Intent(this, FirstAppActivity::class.java)
        startActivity(intent)
    }
}