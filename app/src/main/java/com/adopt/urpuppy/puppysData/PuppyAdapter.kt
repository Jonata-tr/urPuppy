package com.adopt.urpuppy.puppysData

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.adopt.urpuppy.R

class PuppyAdapter(private val puppyList: ArrayList<PuppysDataClass>): RecyclerView.Adapter<PuppyAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.pets_row, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = puppyList[position]
        holder.rvDogImage.setImageResource(currentItem.puppyImage)
        holder.rvDogName.text = currentItem.puppyName
        holder.rvDogAge.text = currentItem.puppyAge
        holder.rvDogSex.text = currentItem.puppySex
        holder.rvDogLocation.text = currentItem.puppyLocation
        holder.rvDogRace.text = currentItem.puppyRace
    }

    override fun getItemCount(): Int {
        return puppyList.size
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val rvDogImage:ImageView = itemView.findViewById(R.id.dogImage)
        val rvDogName:TextView = itemView.findViewById(R.id.dogName)
        val rvDogAge:TextView = itemView.findViewById(R.id.dogAge)
        val rvDogSex:TextView = itemView.findViewById(R.id.dogSex)
        val rvDogLocation:TextView = itemView.findViewById(R.id.adoptionLocation)
        val rvDogRace:TextView = itemView.findViewById(R.id.dogRace)
    }
}