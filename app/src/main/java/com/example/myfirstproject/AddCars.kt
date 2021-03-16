package com.example.myfirstproject

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myfirstproject.databinding.ActivityAddCarsBinding

class AddCars : AppCompatActivity() {

    private val SELECT_IMAGE_CODE = 1
    private lateinit var binding: ActivityAddCarsBinding
    private var imgUri: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddCarsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val model = intent.getStringExtra("EXTRA_MODEL")
        binding.addModel.setText(model)
        imgUri = Uri.parse("@drawable/icon.jpg")

        binding.addSave.setOnClickListener {
            Intent().apply {
                putExtra("EXTRA_MODEL", binding.addModel.text.toString())
                putExtra("EXTRA_SCREEN", binding.addMark.text.toString())
                putExtra("EXTRA_HARDWARE", binding.addYear.text.toString())
                putExtra("EXTRA_URI", imgUri.toString())

                setResult(Activity.RESULT_OK, this)
                finish()
            }
        }
        binding.addImage.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/*"
            startActivityForResult(intent, SELECT_IMAGE_CODE)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == SELECT_IMAGE_CODE) {
            imgUri = data?.data
            binding.addImage.setImageURI(imgUri)
        } else {
            binding.addImage.setImageURI(Uri.parse("@drawable/icon.jpg"))
        }
    }
}
