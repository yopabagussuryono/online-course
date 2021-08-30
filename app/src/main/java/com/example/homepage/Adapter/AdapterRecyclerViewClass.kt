package com.example.homepage.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.homepage.Model.ModelDataClass
import com.example.homepage.R

class AdapterRecyclerViewClass (private val data: ArrayList<ModelDataClass>) :
                                RecyclerView.Adapter<AdapterRecyclerViewClass.ViewHolder>(){

    class ViewHolder(view : View) : RecyclerView.ViewHolder(view) {

        val txClassName : TextView
        val txClassType : TextView
        val txStudentSize : TextView
        val txTeacherName : TextView

        init {
            txClassName = view.findViewById(R.id.txtsclass)
            txClassType = view.findViewById(R.id.txtsclass2)
            txStudentSize = view.findViewById(R.id.txtsclass4)
            txTeacherName = view.findViewById(R.id.txrcv2)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_rcview_sclass, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val student_size : Int = data.get(position).studentSize
        val class_name : String = data.get(position).className
        val class_type : String = data.get(position).classType
        val teacher_name : String = data.get(position).teacherName

        holder.txClassName.text = class_name
        holder.txClassType.text = class_type
        holder.txStudentSize.text = student_size.toString()
        holder.txTeacherName.text = teacher_name
    }

    override fun getItemCount(): Int {
        return data.size
    }
}