package com.example.myfirstproject.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myfirstproject.R
import com.example.myfirstproject.data.CarsItem
import com.example.myfirstproject.databinding.ActivityAddCarsBinding
import com.example.myfirstproject.databinding.ActivityItemViewBinding


class Adapter(var cars: List<CarsItem>) :
    RecyclerView.Adapter<Adapter.CarsViewHolder>(){
    lateinit var binding: ActivityItemViewBinding
    inner class CarsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_item_view, parent, false)
        return CarsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return cars.size
    }

    override fun onBindViewHolder(holder: CarsViewHolder, pos: Int) {
        holder.itemView.apply {
           binding.fieldmodel.text = cars[pos].model
            binding.fieldMark.text = cars[pos].mark
            binding.fieldYear.text = cars[pos].year.toString()
            binding.fieldImage.setImageDrawable(cars[pos].img)
        }
    }
}