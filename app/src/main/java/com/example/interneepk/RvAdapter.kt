package com.example.interneepk

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView


class RvAdapter(private var dataList: ArrayList<RvModel>):RecyclerView.Adapter<RvAdapter.MyViewHolder>() {

    class MyViewHolder(view: View): RecyclerView.ViewHolder(view){
        val ivImg: ImageView = itemView.findViewById(R.id.ivImg)
        val tvName: TextView = itemView.findViewById(R.id.tvName)
        val btn: Button = itemView.findViewById(R.id.btnApply)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.rv_item,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = dataList[position]
        holder.ivImg.setImageResource(currentItem.ivMain)
        holder.tvName.text = currentItem.name
        holder.btn.setOnClickListener {
            Toast.makeText(holder.itemView.context,"Visit Internee.pk for complete details",Toast.LENGTH_SHORT).show()
        }
    }
}