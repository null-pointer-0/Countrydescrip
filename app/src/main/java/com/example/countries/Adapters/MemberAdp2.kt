package com.example.countries.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.countries.Models.Language
import com.example.countries.R
import kotlinx.android.synthetic.main.borderview.view.*
import kotlinx.android.synthetic.main.countrylayout.view.*

class MemberAdp2(val list:List<Language>) : RecyclerView.Adapter<MemberAdp2.viewholder>(){

    class viewholder(itemView: View) :RecyclerView.ViewHolder(itemView){
        var langtext: TextView = itemView.borderview
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemberAdp2.viewholder {
        val view1 = LayoutInflater.from(parent.context)
            .inflate(R.layout.borderview,parent,false)
        return viewholder(view1)
    }

    override fun onBindViewHolder(holder: MemberAdp2.viewholder, position: Int) {
        holder.langtext.text = list[position].name
    }

    override fun getItemCount(): Int {
        return list.size
    }
}