package com.example.myfirstproject.`object`

import android.content.Context
import androidx.core.content.ContextCompat
import com.example.myfirstproject.R
import com.example.myfirstproject.data.CarsItem

fun initListCar(context: Context): MutableList<CarsItem> {
    return mutableListOf(
        CarsItem(
            ContextCompat.getDrawable(context, R.drawable.audi),
            "Audi",
            "R8",
            2010
        ),
        CarsItem(
            ContextCompat.getDrawable(context, R.drawable.bugati),
            "Bugatti",
            "Verone",
            2011

        ),
        CarsItem(
            ContextCompat.getDrawable(context, R.drawable.lamba),
            "Lamborgini",
            "Avendator",
            2009
        )
    )
}
