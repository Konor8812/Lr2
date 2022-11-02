package com.illia.lr2

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.illia.lr2.databinding.ActivityMainBinding
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        println("creating new main activity")
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

    }



    fun getResultOnTap(v : View){
        findViewById<TextView>(R.id.InvalidDataTextView).setText("")

//        val num1Value = findViewById<EditText>(R.id.num1).text
//        val num2Value = findViewById<EditText>(R.id.num2).text
//        val operation = findViewById<EditText>(R.id.operation).text

        val num1Value = binding.num1.text
        val num2Value = binding.num2.text
        val operation = binding.operation.text

        if(num1Value.matches("-?\\d{1,5}".toRegex()) &&
            num2Value.matches("-?\\d{1,5}".toRegex()) &&
            operation.matches("[+-/*]".toRegex())){


            val resultValue = calculate(num1Value.toString().toInt(), num2Value.toString().toInt(), operation.toString())

            startActivity(Intent(this, ResultActivity::class.java).apply {
                putExtra("resultValue", resultValue)
            })

        }else{
            findViewById<TextView>(R.id.InvalidDataTextView).setText("Enter valid data: -99999...99999 for numbers, supported operations: + - * /")
        }


        }

    private fun calculate(n1: Int, n2: Int, op: String): Int {
        return when(op){
            "-" -> n1 - n2
            "+" -> n1 + n2
            "*" -> n1 * n2
            "/" -> try {
                n1 / n2
            } catch (ex: Exception){
                0
            }
            else -> 0
        }
    }
}