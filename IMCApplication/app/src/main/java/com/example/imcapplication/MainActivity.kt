package com.example.imcapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    private var isMaleSelected: Boolean = true
    private var isFemaleSelected: Boolean = false
    private var currentWeight: Int = 70
    private var currentAge: Int = 50

    private lateinit var maleView: CardView
    private lateinit var femaleView: CardView
    private lateinit var tvHeight: TextView
    private lateinit var rsHeight: RangeSlider
    private lateinit var btnRestarPeso: FloatingActionButton
    private lateinit var btnAñadirPeso: FloatingActionButton
    private lateinit var tvPeso: TextView
    private lateinit var btnRestarEdad: FloatingActionButton
    private lateinit var btnAñadirEdad: FloatingActionButton
    private lateinit var tvEdad: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initComponents()
        initListeners()
        initUI()
    }

    private fun initUI() {
        setSelectedGenderColor()
        setWeight()
        setAge()
    }

    private fun initListeners() {
        maleView.setOnClickListener {
            changeSelectedGenderColor()
            setSelectedGenderColor()
        }
        femaleView.setOnClickListener {
            changeSelectedGenderColor()
            setSelectedGenderColor()
        }
        rsHeight.addOnChangeListener { _, value, _ ->
//            val df = DecimalFormat("#.##")
//            val result = df.format(value)
//            tvHeight.text = result.toString()
            tvHeight.text = "${value.toInt()} cm"

        }

        btnRestarPeso.setOnClickListener {
            currentWeight -= 1
            setWeight()
        }
        btnAñadirPeso.setOnClickListener {
            currentWeight += 1
            setWeight()
        }

        btnRestarEdad.setOnClickListener {
            currentAge -= 1
            setAge()
        }
        btnAñadirEdad.setOnClickListener {
            currentAge += 1
            setAge()
        }

    }

    private fun setAge() {
        tvEdad.text = currentAge.toString()
    }

    private fun setWeight() {
        tvPeso.text = currentWeight.toString()
    }

    private fun initComponents() {
        maleView = findViewById(R.id.viewMale)
        femaleView = findViewById(R.id.viewFemale)
        tvHeight = findViewById(R.id.tvHeihgt)
        rsHeight = findViewById(R.id.rsHeight)
        btnRestarPeso = findViewById(R.id.btnRestarPeso)
        btnAñadirPeso = findViewById(R.id.btnAñadirPeso)
        tvPeso = findViewById(R.id.tvPeso)
        btnRestarEdad = findViewById(R.id.btnRestarEdad)
        btnAñadirEdad = findViewById(R.id.btnAñadirEdad)
        tvEdad = findViewById(R.id.tvEdad)

    }

    private fun changeSelectedGenderColor() {
        isMaleSelected = !isMaleSelected
        isFemaleSelected = !isFemaleSelected
    }

    private fun setSelectedGenderColor() {
        maleView.setCardBackgroundColor(getBackgroundColor(isMaleSelected))
        femaleView.setCardBackgroundColor(getBackgroundColor(isFemaleSelected))
    }

    private fun getBackgroundColor(isSelectedComponent: Boolean): Int {

        val colorReference = if (isSelectedComponent) {
            R.color.background_component_selected
        } else {
            R.color.background_component
        }

        return ContextCompat.getColor(this, colorReference)
    }

}