package com.example.imcapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.imcapplication.MainActivity.Companion.IMC_KEY

class IMCResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imcresult)
        val result: Double = intent.extras?.getDouble(IMC_KEY) ?: -1.0
    }
}