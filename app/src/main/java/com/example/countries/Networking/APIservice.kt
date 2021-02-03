package com.example.countries.Networking

import com.example.countries.Example
import retrofit2.Call
import retrofit2.http.GET

interface APIservice {
    @GET("asia")
    fun getCountriesData() : Call<List<Example>>
}