package com.example.homepage.Activity.FragmentOnMainActivity

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.homepage.Adapter.AdapterRecyclerViewHome
import com.example.homepage.R

class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var list: ArrayList<Int>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recy : RecyclerView = view.findViewById(R.id.rv_home)

        var list: ArrayList<Int> = ArrayList<Int>()

        list.add(R.drawable.sport)
        list.add(R.drawable.sains)
        list.add(R.drawable.sains2)
        list.add(R.drawable.english)
        list.add(R.drawable.bahasa)
        list.add(R.drawable.music)
        list.add(R.drawable.math)
        list.add(R.drawable.fisik)
        list.add(R.drawable.computer)
        list.add(R.drawable.sosial)
        list.add(R.drawable.art)
        list.add(R.drawable.history)
        list.add(R.drawable.religius)

        val adapter = AdapterRecyclerViewHome(list)
        recy.layoutManager = GridLayoutManager(activity,3,GridLayoutManager.HORIZONTAL,false)
        recy.adapter = adapter
    }
}