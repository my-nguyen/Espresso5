package com.nguyen.espresso5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.nguyen.espresso5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.changeText.setOnClickListener {
            binding.inputField.setText("Lalala")
        }
        binding.switchActivity.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("input", binding.inputField.text.toString())
            startActivity(intent)
        }
    }

    /*fun onClick(view: View) {
        when (view.id) {
            R.id.changeText -> binding.inputField.setText("Lalala")
            R.id.switchActivity -> {
                val intent = Intent(this, SecondActivity::class.java)
                intent.putExtra("input", binding.inputField.text.toString())
                startActivity(intent)
            }
        }
    }*/
}