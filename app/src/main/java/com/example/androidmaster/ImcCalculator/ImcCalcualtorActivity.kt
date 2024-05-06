package com.example.androidmaster.ImcCalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.example.androidmaster.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider
import java.text.DecimalFormat

class ImcCalcualtorActivity : AppCompatActivity() {

    private var isMaleSelected: Boolean = true
    private var isFemaleSelected:Boolean = false
    private var currentWeight:Int = 70
    private var currentAge:Int = 20
    private var currentHeight:Int = 120

    private lateinit var maleView: CardView
    private lateinit var femaleView: CardView
    private lateinit var TvHeight: TextView
    private lateinit var RsHeight: RangeSlider
    private lateinit var btnSubtractWeight: FloatingActionButton
    private lateinit var btnPlusWeight: FloatingActionButton
    private lateinit var TvWeight: TextView
    private lateinit var btnSubtractAge: FloatingActionButton
    private lateinit var btnPlusAge: FloatingActionButton
    private lateinit var TvAge: TextView
    private lateinit var btnCalculate: Button

    companion object {
        const val IMC_KEY = "IMC_RESULT"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc_calcualtor)
        initComponents()
        initListener()
        setWeight()
        setAge()
    }

    private fun initComponents(){
        maleView = findViewById(R.id.male)
        femaleView = findViewById(R.id.female)
        TvHeight = findViewById(R.id.TvHeight)
        RsHeight = findViewById(R.id.RsHeight)
        btnSubtractWeight = findViewById(R.id.btnSubtractWeight)
        btnPlusWeight = findViewById(R.id.btnPlusWeight)
        TvWeight = findViewById(R.id.TvWeight)
        btnSubtractAge = findViewById(R.id.AgeSubstract)
        btnPlusAge = findViewById(R.id.AgePlus)
        TvAge = findViewById(R.id.TvAge)
        btnCalculate = findViewById(R.id.btnCalculate)
    }

    private fun initListener() {
        maleView.setOnClickListener {
            changeGender()
            setGenderColor()
        }
        femaleView.setOnClickListener {
            changeGender()
            setGenderColor()
        }
        RsHeight.addOnChangeListener{_, value, _->
            val df = DecimalFormat("#.##")
            currentHeight = df.format(value).toInt()
            TvHeight.text = "$currentHeight cm"

        }
        btnPlusWeight.setOnClickListener{
            currentWeight += 1
            setWeight()
        }

        btnSubtractWeight.setOnClickListener{
            currentWeight -= 1
            setWeight()
        }
        btnPlusAge.setOnClickListener{
            currentAge += 1
            setAge()
        }

        btnSubtractAge.setOnClickListener{
            currentAge -= 1
            setAge()
        }

        btnCalculate.setOnClickListener {
            val result = calculateImc()
            navigateToResult(result)
        }
        
    }

    private fun changeGender() {
        isMaleSelected = !isMaleSelected
        isFemaleSelected = !isFemaleSelected
    }

    private fun setGenderColor() {
        maleView.setCardBackgroundColor(getBackgraundColor(isMaleSelected))
        femaleView.setCardBackgroundColor(getBackgraundColor(isFemaleSelected))
    }

    private fun getBackgraundColor(isSelectedComponent: Boolean): Int {
        val colorReference = if(isSelectedComponent) {
            R.color.background_component_select
        } else {
            R.color.background_component
        }
        return ContextCompat.getColor(this, colorReference)
    }

    private fun setWeight(){
        TvWeight.text = currentWeight.toString()
    }

    private fun setAge() {
        TvAge.text = currentAge.toString()
    }

    private fun calculateImc(): Double {
        val df = DecimalFormat("#,##")
        val imc = currentWeight.toDouble()/(currentHeight.toDouble()/100 *currentHeight.toDouble()/100)
        return df.format(imc).toDouble()
    }

    private fun navigateToResult(result: Double) {
        val intent = Intent(this, resultActivity::class.java)
        intent.putExtra(IMC_KEY, result)
        startActivity(intent)
    }
}