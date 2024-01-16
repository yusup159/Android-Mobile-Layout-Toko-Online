package com.example.newfp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class AdapterAllBarang(private val newsList: ArrayList<NewsAllBarang>) :
    RecyclerView.Adapter<AdapterAllBarang.MyViewHolderAdapter>(){
    class MyViewHolderAdapter(itemView : View) : RecyclerView.ViewHolder(itemView){
        val imageBarang : ShapeableImageView = itemView.findViewById(R.id.titleimage)
        val headinbarang : TextView = itemView.findViewById(R.id.Heading)
        val biasabae  :TextView = itemView.findViewById(R.id.biasa)
        val regobarang :TextView = itemView.findViewById(R.id.amount)
        val ul :TextView = itemView.findViewById(R.id.ulasanbarang)
        val jm :TextView = itemView.findViewById(R.id.jumlahterjual)
        val rt :TextView = itemView.findViewById(R.id.rattingpersen)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolderAdapter {
       val  itemView = LayoutInflater.from(parent.context).inflate(R.layout.allbarang,parent,false)
        return MyViewHolderAdapter(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolderAdapter, position: Int) {
        val currentItem =newsList[position]
        holder.imageBarang.setImageResource(currentItem.Imagebarang)
        holder.headinbarang.text = currentItem.headinbarang
        holder.biasabae.text =currentItem.biasabae
        holder.regobarang.text =currentItem.regobarang
        holder.ul.text=currentItem.ulbarang
        holder.jm.text = currentItem.jumlah
        holder.rt.text=currentItem.persen
    }

    override fun getItemCount(): Int {
        return newsList.size
    }
}