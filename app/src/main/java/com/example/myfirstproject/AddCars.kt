package com.example.myfirstproject

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myfirstproject.databinding.ActivityAddCarsBinding
import com.example.myfirstproject.databinding.ActivityMainBinding


class AddCars : AppCompatActivity() {

    val SELECT_IMAGE_CODE = 1
    lateinit var binding: ActivityAddCarsBinding
    var imgUri: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_cars)

        val model = intent.getStringExtra("EXTRA_MODEL")
        binding.addModel.setText(model)

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
