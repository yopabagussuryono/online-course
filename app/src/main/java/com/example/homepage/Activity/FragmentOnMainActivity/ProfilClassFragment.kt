package com.example.homepage.Activity.FragmentOnMainActivity

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.example.homepage.Adapter.AdapterRecyclerViewClass
import com.example.homepage.Adapter.AdapterViewPagerClass
import com.example.homepage.Model.ModelData
import com.example.homepage.Model.ModelDataClass
import com.example.homepage.R


class ProfilClassFragment : Fragment(R.layout.fragment_profil_class) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val context : Context = requireActivity()

        val viewPager : ViewPager = view.findViewById(R.id.vpclass)
        val listClass : RecyclerView = view.findViewById(R.id.rcclass)

        var data: ArrayList<ModelData> = ArrayList()
        data.add(
            ModelData(
                R.drawable.computer,
                "Komputer"
            )
        )
        data.add(
            ModelData(
                R.drawable.english,
                "B.Inggris"
            )
        )
        data.add(
            ModelData(
                R.drawable.histori,
                "Sejarah"
            )
        )
        data.add(
            ModelData(
                R.drawable.math,
                "Matematika"
            )
        )
        data.add(
            ModelData(
                R.drawable.sport,
                "OlahRaga"
            )
        )

        val adapterViewP = AdapterViewPagerClass(context,data)
        viewPager.adapter = adapterViewP

        var list: ArrayList<ModelDataClass> = ArrayList()
        list.add(ModelDataClass("XII IPA","1",25,"Yopa S., S.Kom."))
        list.add(ModelDataClass("XII IPS","2",20,"Kevin S., S.Kom."))

        val adapterRecyc = AdapterRecyclerViewClass(list)
        listClass.layoutManager = LinearLayoutManager(context,RecyclerView.VERTICAL,false)
        listClass.adapter = adapterRecyc

    }
}