package com.matheussilas.covid_19info.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.matheussilas.covid_19info.ApiService
import com.matheussilas.covid_19info.response.CountryResponse
import com.matheussilas.covid_19info.response.GenericResponse
import com.matheussilas.covid_19info.response.StatesBrResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CountryViewModel: ViewModel() {

    fun countryInfo(): LiveData<List<CountryResponse>> {
        return getCountry()
    }

    private fun getCountry(): LiveData<List<CountryResponse>> {
        val result = MutableLiveData<List<CountryResponse>>()

        ApiService.service.getCountry().enqueue(object :
            Callback<GenericResponse<CountryResponse>> {
            override fun onFailure(call: Call<GenericResponse<CountryResponse>>, t: Throwable) {
                result.value = null
            }

            override fun onResponse(
                call: Call<GenericResponse<CountryResponse>>,
                response: Response<GenericResponse<CountryResponse>>
            ) {
                if(response.isSuccessful ){
                    var resulta = response.body()
                    result.value = resulta!!.data
                }else{
                    result.value = null
                }
            }

        })


        return result
    }

}