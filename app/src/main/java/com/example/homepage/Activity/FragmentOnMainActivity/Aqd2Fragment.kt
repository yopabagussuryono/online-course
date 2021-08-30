package com.example.homepage.Activity.FragmentOnMainActivity

import android.app.Activity
import android.app.DatePickerDialog
import android.content.Context
import android.content.Intent
import android.icu.util.Calendar
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.DatePicker
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.cardview.widget.CardView
import androidx.viewpager.widget.ViewPager
import com.example.homepage.Activity.ActivityAssigment
import com.example.homepage.Adapter.AdapterVPAssigment
import com.example.homepage.R
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList


class Aqd2Fragment : Fragment(R.layout.fragment_aqd2) {


    @RequiresApi(Build.VERSION_CODES.N)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val context: Context = requireActivity()

        var assigment: CardView = view.findViewById(R.id.cardvaqd21)
        var viewP: ViewPager = view.findViewById(R.id.vpassig2)

        val dateda = view.findViewById<TextView>(R.id.dateday)
        val datedat = view.findViewById<TextView>(R.id.datedate)
        val clikon = view.findViewById<LinearLayout>(R.id.reltgl)

            val myCalendar = Calendar.getInstance()
            val year = myCalendar.get(Calendar.YEAR)
            val month = myCalendar.get(Calendar.MONTH)
            val day = myCalendar.get(Calendar.DAY_OF_MONTH)


        clikon.setOnClickListener {
            val datepicker = DatePickerDialog(context,DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->

                val simpledate : SimpleDateFormat = SimpleDateFormat("EEEE")
                val tglplh : Date = Date(year,month,dayOfMonth-1)
                val dayOfWeek : String = simpledate.format(tglplh)
                dateda.text = dayOfWeek
                datedat.text = dayOfMonth.toString()

            },year,month,day)
            datepicker.show()

        }

        //set data ViewPager
        var data: ArrayList<Int> = ArrayList()
        data.add(R.drawable.music)
        data.add(R.drawable.school)

        //set adapter ViewPager
        val adapterViewP = AdapterVPAssigment(context, data)
        viewP.adapter = adapterViewP

        assigment.setOnClickListener(View.OnClickListener {
            val cls: Class<ActivityAssigment> = ActivityAssigment::class.java
            val intent: Intent = Intent(requireActivity(), cls)
            startActivity(intent)
            requireActivity().finish()
        })

    }
}
