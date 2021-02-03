package com.example.countries.ViewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.countries.Example
import com.example.countries.Networking.APIclient
import com.example.countries.Networking.APIservice
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CountriesViewModel : ViewModel() {
    var cData:MutableLiveData<List<Example>> = MutableLiveData()
    fun getCountriesobserver():MutableLiveData<List<Example>>{
        return cData
    }
    fun makeNetwrokcall(){
        var netService = APIclient.retro.create(APIservice::class.java)
        var call:Call<List<Example>> = netService.getCountriesData()
        call.enqueue(object:Callback<List<Example>>{
            override fun onResponse(call: Call<List<Example>>, response: Response<List<Example>>) {
                cData.postValue(response.body())
            }
            override fun onFailure(call: Call<List<Example>>, t: Throwable) {
                Log.d("Check",t.message.toString())
            }
        })
    }
}