package com.example.countries.Adapters

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ahmadrosid.svgloader.SvgLoader
import com.example.countries.Example
import com.example.countries.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.countrylayout.view.*

class CountryAdapter(val context:Context, var countrylist:List<Example>,
                     var mActivity: Activity): RecyclerView.Adapter<CountryAdapter.viewholder>() {
    inner class viewholder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val conname: TextView = itemView.countryname
        val conregion: TextView = itemView.countryregion
        val consregion:TextView = itemView.subregion
        val conpop: TextView = itemView.countrypop
        val concapital: TextView = itemView.capital
        val flagpic: ImageView = itemView.findViewById(R.id.flagimage)
        val borders:RecyclerView = itemView.borderlist
        val langs:RecyclerView = itemView.languagelist
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder {
        var view1 = LayoutInflater.from(parent.context).inflate(R.layout.countrylayout,parent,false)
        return viewholder(view1)
    }
    override fun onBindViewHolder(holder: viewholder, position: Int){
        var current = countrylist[position]
        holder.conname.text = current.name
        holder.concapital.text = "Capital:${current.capital}"
        holder.conregion.text = current.region
        holder.conpop.text = "Population:${countrylist[position].population.toString()}"
        holder.consregion.text = current.subregion
        SvgLoader.pluck()
            .with(mActivity)
            .setPlaceHolder(R.mipmap.ic_launcher, R.mipmap.ic_launcher)
            .load(current.flag, holder.flagpic);
        val madp = MemberAdp(current.borders)
        holder.borders.layoutManager = LinearLayoutManager(mActivity)
        holder.borders.adapter = madp
        val madp2 = MemberAdp2(current.languages)
        holder.langs.layoutManager = LinearLayoutManager(mActivity)
        holder.langs.adapter = madp2
        mActivity.progressBar.isVisible=false
    }

    override fun getItemCount(): Int {
        return countrylist.size
    }
}