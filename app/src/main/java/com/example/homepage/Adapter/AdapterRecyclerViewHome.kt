package com.example.homepage.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.homepage.R

class AdapterRecyclerViewHome(private val data: ArrayList<Int>) :
                                RecyclerView.Adapter<AdapterRecyclerViewHome.ViewHolder>(){

    class ViewHolder(view : View) : RecyclerView.ViewHolder(view) {

        val img : ImageView
        init {
             img = view.findViewById(R.id.imgrv)
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_rcview_home, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val gambar : Int = data.get(position)

        holder.img.setImageResource(gambar)

    }
    override fun getItemCount()= data.size
}