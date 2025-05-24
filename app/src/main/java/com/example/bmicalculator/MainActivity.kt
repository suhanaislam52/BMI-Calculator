package com.example.bmicalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.bmicalculator.databinding.ActivityMainBinding
import com.example.bmicalculator.ui.theme.BMICalculatorTheme
import kotlin.math.pow

class MainActivity : ComponentActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.calculateBtn.setOnClickListener{
            calculateBMI()
        }
    }

    private fun calculateBMI(){
        val weight=binding.weightEdit.text.toString().toFloatOrNull()
        val height=binding.heightEdit.text.toString().toFloatOrNull()

        if(weight!= null && height!= null){
            val bmi=weight/(height/100).pow(2)
            val bmiResult=String.format("%.2f",bmi)

            val bmiCategory=when{
                bmi<18.5 ->"Underweight"
                bmi<25 ->"Normal Height"
                bmi<30 -> "Overweight"
                else -> "Obese"
            }
            binding.resultText.text="BMI:$bmiResult\nCategory: $bmiCategory"

        }else{
            binding.resultText.text="Invalid Input"
        }
    }
}

