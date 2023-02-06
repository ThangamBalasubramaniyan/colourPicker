package com.firstapp.muvierecktask

import android.Manifest
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.drawable.BitmapDrawable
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.firstapp.muvierecktask.databinding.ActivityMainBinding
import com.nvt.color.ColorPickerDialog
import java.io.File
import java.io.FileOutputStream
import java.io.OutputStream

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
                this,
                Color.BLACK, // color init
                true, // true is show alpha
                object : ColorPickerDialog.OnColorPickerListener {
                    override fun onCancel(dialog: ColorPickerDialog?) {
                        // handle click button Cancel
                    }

                    override fun onOk(dialog: ColorPickerDialog?, colorPicker: Int) {
                        binding.imageView.setBackgroundColor(colorPicker)
                    }
                })
            colorPicker.show()
        }

        binding.button.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (ContextCompat.checkSelfPermission(this, Manifest.permission.MANAGE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
                    100)
                } else {
                    saveToGallery()
                }
            } else {
                saveToGallery()
            }
        }

    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray,
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 100) {
            if (grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                saveToGallery()
            } else {
                Toast.makeText(this, "Permission not granted, so image can't be saved in storage", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun saveToGallery() {
        val externalStorageState = Environment.getExternalStorageState()
        if (externalStorageState.equals(Environment.MEDIA_MOUNTED)) {
            val storageDirectory = Environment.getExternalStorageDirectory().toString()
            val file = File(storageDirectory,"save_image.png")
            try {
                Toast.makeText(this, "Image saved successfully ${Uri.parse(file.absolutePath)}", Toast.LENGTH_SHORT).show()
                val stream: OutputStream = FileOutputStream(file)
                val drawable = ContextCompat.getDrawable(applicationContext, R.drawable.demo)
                val bitmap = (drawable as BitmapDrawable).bitmap
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream)
                stream.flush()
                stream.close()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        } else {
            Toast.makeText(this, "Unable to access storage", Toast.LENGTH_SHORT).show()
        }
    }

}