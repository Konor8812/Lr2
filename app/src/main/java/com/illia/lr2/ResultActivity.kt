package com.illia.lr2

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.illia.lr2.databinding.ActivityResultBinding
import org.w3c.dom.Text

class ResultActivity : AppCompatActivity() {


    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        println("creating new result activity")
        super.onCreate(savedInstanceState)

        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val result = intent.getIntExtra("resultValue", 0)
        println(result)

        val resultTextView = findViewById<TextView>(R.id.ResultTextView)

        resultTextView.setText(result.toString())

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