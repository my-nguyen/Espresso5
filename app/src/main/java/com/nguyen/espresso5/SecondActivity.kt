package com.nguyen.espresso5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nguyen.espresso5.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.resultView.text = intent.extras?.getString("input")!!
    }
}