package com.example.myfirstproject.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myfirstproject.data.CarsItem
import com.example.myfirstproject.databinding.ActivityItemViewBinding


class Adapter(var cars: List<CarsItem>) :
    RecyclerView.Adapter<Adapter.CarsViewHolder>() {

    inner class CarsViewHolder(private val binding: ActivityItemViewBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(car: CarsItem) {
            binding.fieldmodel.text = car.model
            binding.fieldMark.text = car.mark
            binding.fieldYear.text = car.year.toString()
            binding.fieldImage.setImageDrawable(car.img)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val carItemBinding = ActivityItemViewBinding.inflate(layoutInflater, parent, false)
        return CarsViewHolder(carItemBinding)
    }

    override fun getItemCount(): Int {
        return cars.size
    }

    override fun onBindViewHolder(holder: CarsViewHolder, pos: Int) {
        holder.bind(cars[pos])
    }
}