package com.example.myfirstproject


import android.app.Activity
import android.content.Intent
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myfirstproject.`object`.initListCar
import com.example.myfirstproject.adapter.Adapter
import com.example.myfirstproject.data.CarsItem
import com.example.myfirstproject.databinding.ActivityAddCarsBinding
import com.example.myfirstproject.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    val ADD_CAR_CODE = 1
    lateinit var carAdapter: Adapter

    lateinit var binding: ActivityMainBinding

    var carsList = mutableListOf<CarsItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initListCar(this)

        carAdapter = Adapter(carsList)
        binding.listCars.adapter = carAdapter
        binding.listCars.layoutManager = LinearLayoutManager(this)
        binding.addBtn.setOnClickListener { btn ->
            Intent(this, ActivityAddCarsBinding::class.java).also { newIntent ->
                newIntent.putExtra("EXTRA_MODEL", "Car")
                startActivityForResult(newIntent, ADD_CAR_CODE)
            }
        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == ADD_CAR_CODE) {
            if(resultCode == Activity.RESULT_OK) {
                data?.let { result ->
                    val model = result.getStringExtra("EXTRA_MODEL") ?: "Unknown"
                    val mark = result.getStringExtra("EXTRA_SCREEN") ?: "Default"
                    val year = result.getStringExtra("EXTRA_HARDWARE") ?: "Don't know"
                    val imageUri = result.getStringExtra("EXTRA_URI")
                    var img: Drawable? = null
                    imageUri?.let { imgUri ->
                        img = uriToDrawable(imgUri)
                    }

                    val newCar = CarsItem(img, model, mark, year.toInt())

                    carsList.add(newCar)
                    carAdapter.notifyItemInserted(carsList.size - 1)
                }
            }
        }
    }
    private fun uriToDrawable(imageUri: String) : Drawable {
        val inputStream = contentResolver.openInputStream(Uri.parse(imageUri))
        return Drawable.createFromStream(inputStream, imageUri)
    }
}