package com.firstapp.muvierecktask

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.firstapp.muvierecktask.databinding.ActivityMainBinding
import com.nvt.color.ColorPickerDialog
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

        binding.imageButton5.setOnClickListener {

            val colorPicker = ColorPickerDialog(
                applicationContext,
                Color.BLACK, // color init
                true, // true is show alpha
                object : ColorPickerDialog.OnColorPickerListener {
                    override fun onCancel(dialog: ColorPickerDialog?) {
                        // handle click button Cancel
                    }

                    override fun onOk(dialog: ColorPickerDialog?, colorPicker: Int) {
                        binding.imageView.background = ContextCompat.getDrawable(applicationContext, colorPicker)
                    }
                })
            colorPicker.show()
        }

    }
}