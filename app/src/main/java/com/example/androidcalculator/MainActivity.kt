package com.example.androidcalculator

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.androidcalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set up click listeners for operation buttons
        binding.btnAdd.setOnClickListener { performOperation("+") }
        binding.btnSubtract.setOnClickListener { performOperation("-") }
        binding.btnMultiply.setOnClickListener { performOperation("*") }
        binding.btnDivide.setOnClickListener { performOperation("/") }
    }

    private fun performOperation(operation: String) {
        // Get input values
        val number1 = binding.etNumber1.text.toString().toDoubleOrNull()
        val number2 = binding.etNumber2.text.toString().toDoubleOrNull()

        if (number1 == null || number2 == null) {
            binding.tvResult.text = "Please enter valid numbers"
            Toast.makeText(this,"Please enter valid number", Toast.LENGTH_SHORT).show()
            return
        }

        val result = when (operation) {
            "+" -> number1 + number2
            "-" -> number1 - number2
            "*" -> number1 * number2
            "/" -> if (number2 != 0.0) number1 / number2 else "Cannot divide by zero"
            else -> "Invalid operation"
        }

        binding.tvResult.text = result.toString()
    }
}
