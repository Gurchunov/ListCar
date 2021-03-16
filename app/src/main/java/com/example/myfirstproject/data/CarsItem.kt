package com.example.myfirstproject.data

import android.graphics.drawable.Drawable
import java.io.Serializable

data class CarsItem(val img: Drawable?, val model: String, val mark: String, val year: Int) : Serializable
