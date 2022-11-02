package com.illia.lr2

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.illia.lr2.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {


    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        println("creating new result activity")
        super.onCreate(savedInstanceState)

        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val result = intent.getIntExtra("resultValue", 0)
        println(result)

//        val resultTextView = findViewById<TextView>(R.id.ResultTextView)
//        resultTextView.setText(result.toString())

        val rtv = binding.ResultTextView
        rtv.setText(result.toString())

    }

    override fun onBackPressed (){
        println("onBack called")
        super.onBackPressed()
    }

    fun returnToMainActivity(v : View){
        onBackPressed()
//        startActivity((Intent(this, MainActivity::class.java)))
    }
}