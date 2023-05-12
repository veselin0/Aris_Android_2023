package com.example.imcapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    private var isMaleSelected: Boolean = true
    private var isFemaleSelected: Boolean = false

    private lateinit var maleView: CardView
    private lateinit var femaleView: CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initComponents()
        initListeners()
        initUI()
    }

    private fun initUI() {
        setSelectedGenderColor()
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
    }

    private fun initComponents() {
        maleView = findViewById(R.id.viewMale)
        femaleView = findViewById(R.id.viewFemale)
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