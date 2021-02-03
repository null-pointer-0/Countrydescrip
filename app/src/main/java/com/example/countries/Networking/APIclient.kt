package com.example.countries.Networking

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class APIclient {
    companion object {
        val baseUrl = "https://restcountries.eu/rest/v2/region/"
        var retro = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}