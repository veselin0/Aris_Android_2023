package com.example.imcapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.imcapplication.MainActivity.Companion.IMC_KEY

class IMCResultActivity : AppCompatActivity() {

    private lateinit var tvResult: TextView
    private lateinit var tvIMC: TextView
    private lateinit var tvDescription: TextView
    private lateinit var btnRecalculate: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imcresult)
        val result: Double = intent.extras?.getDouble(IMC_KEY) ?: -1.0

        initComponents()
        initUI(result)
        initListeners()
    }

    private fun initListeners() {
        btnRecalculate.setOnClickListener { onBackPressed() }
    }

    private fun initUI(result: Double) {
        tvIMC.text = result.toString()
        when (result) {
            in 0.00..18.5 -> {
                tvResult.text = getString(R.string.low_weight)
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.low_weight))
                tvDescription.text = getString(R.string.low_weight_description)
            }

            in 18.51..24.99 -> {
                tvResult.text = getString(R.string.normal_weight)
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.normal_weight))
                tvDescription. text = getString(R.string.normal_weigt_description)
            }

            in 25.00..29.99 -> {
                tvResult.text = getString(R.string.overweight)
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.high_weight))
                tvDescription.text = getString(R.string.overweight_description)
            }

            in 30.00..99.99 -> {
                tvResult.text = getString(R.string.obesity)
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.obesity))
                tvDescription.text = getString(R.string.obesity_description)
            }

            else -> {
                tvIMC.text = getString(R.string.error)
                tvResult.text = getString(R.string.error)
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.obesity))
                tvDescription.text = getString(R.string.error)
            }
        }
    }

    private fun initComponents() {
        tvResult = findViewById(R.id.tvResult)
        tvIMC = findViewById(R.id.tvIMC)
        tvDescription = findViewById(R.id.tvDescription)
        btnRecalculate = findViewById(R.id.btnRecalculate)
    }
}