package com.example.countries.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.countries.R
import kotlinx.android.synthetic.main.borderview.view.*

class MemberAdp(val list:List<String>) : RecyclerView.Adapter<MemberAdp.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view1 = LayoutInflater.from(parent.context)
                    .inflate(R.layout.borderview,parent,false)
        return ViewHolder(view1)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bordertext.text = list[position]
    }

    override fun getItemCount(): Int {
            return list.size
    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var bordertext:TextView = itemView.borderview
    }
}