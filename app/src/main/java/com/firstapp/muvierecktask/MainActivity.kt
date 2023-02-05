package com.firstapp.muvierecktask

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.firstapp.muvierecktask.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.greenButton.setOnClickListener {
            binding.imageView.background = ContextCompat.getDrawable(applicationContext, R.color.green)
        }

        binding.magentaButton.setOnClickListener {
            binding.imageView.background = ContextCompat.getDrawable(applicationContext, R.color.magenta)
        }

        binding.yellowButton.setOnClickListener {
            binding.imageView.background = ContextCompat.getDrawable(applicationContext, R.color.yellow)
        }

        binding.navyBlueButton.setOnClickListener {
            binding.imageView.background = ContextCompat.getDrawable(applicationContext, R.color.navy)
        }

        binding.orangeButton.setOnClickListener {
            binding.imageView.background = ContextCompat.getDrawable(applicationContext, R.color.orange)
        }

    }
}