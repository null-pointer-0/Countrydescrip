package com.example.countries

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.countries.Adapters.CountryAdapter
import com.example.countries.ViewModel.CountriesViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var adpt: CountryAdapter
    lateinit var mainmodel:CountriesViewModel
    lateinit var finlist:List<Example>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        countryView.layoutManager = LinearLayoutManager(this)
        countryView.hasFixedSize()
        mainmodel = ViewModelProvider(this).get(CountriesViewModel::class.java)
        mainmodel.getCountriesobserver().observe(this,
            { t ->
                if(t != null){
                    finlist = t
                    adpt = CountryAdapter(this,finlist,this)
                    countryView.adapter = adpt
                }else{
                    Toast.makeText(applicationContext,"oops Can't fetch data",Toast.LENGTH_SHORT).show()
                }
            })
        mainmodel.makeNetwrokcall()
    }
}