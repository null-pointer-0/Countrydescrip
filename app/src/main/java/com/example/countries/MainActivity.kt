package com.example.countries

import android.content.Context
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ProgressBar
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.countries.Adapters.CountryAdapter
import com.example.countries.ViewModel.CountriesViewModel
import kotlinx.android.synthetic.main.activity_main.*
import java.util.jar.Manifest
import android.net.ConnectivityManager




class MainActivity : AppCompatActivity() {
    lateinit var adpt: CountryAdapter
    lateinit var mainmodel:CountriesViewModel
    lateinit var finlist:List<Example>
    var requestcode:Int = 100
    lateinit var prgbar:ProgressBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        prgbar = findViewById(R.id.progressBar)
        countryView.layoutManager = LinearLayoutManager(this)
        countryView.hasFixedSize()
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.INTERNET)
            == PackageManager.PERMISSION_DENIED) {

            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.INTERNET), requestcode)
        }
        else{
                mainmodel = ViewModelProvider(this).get(CountriesViewModel::class.java)
                mainmodel.getCountriesobserver().observe(this,
                    { t ->
                        if (t != null) {
                            finlist = t
                            adpt = CountryAdapter(this, finlist, this)
                            countryView.adapter = adpt
                        } else {
                            Toast.makeText(applicationContext, "oops Can't fetch data", Toast.LENGTH_SHORT).show()
                        }
                    })
                mainmodel.makeNetwrokcall()
            }
        }
}