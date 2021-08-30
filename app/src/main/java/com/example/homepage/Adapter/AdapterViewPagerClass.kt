package com.example.homepage.Adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import com.example.homepage.Model.ModelData
import com.example.homepage.R

public class AdapterViewPagerClass(var context: Context, var data: ArrayList<ModelData>) :
    PagerAdapter() {

    private lateinit var layoutInflater : LayoutInflater

    override fun getCount(): Int {
        return data.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view.equals(`object`)
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        layoutInflater = LayoutInflater.from(context)
        var view = layoutInflater.inflate(R.layout.item_viewpage_profilclass,container,false)

        var nameClass : TextView = view.findViewById<TextView>(R.id.txnmclassvp)
        var imageClass : ImageView = view.findViewById<ImageView>(R.id.imgvpclass)

        container.addView(view,0)

        nameClass.text = data.get(position).titel
        Log.e("Nama",""+data.get(position).titel)
        imageClass.setImageResource(data.get(position).gambar)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }
}