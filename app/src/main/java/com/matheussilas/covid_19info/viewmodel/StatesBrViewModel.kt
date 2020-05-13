package com.matheussilas.covid_19info.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.matheussilas.covid_19info.ApiService
import com.matheussilas.covid_19info.response.StatesBrResponse
import com.matheussilas.covid_19info.response.GenericResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class StatesBrViewModel : ViewModel() {
    fun brazilInfo(): LiveData<List<StatesBrResponse>> {
        return getBrazil()
    }

    private fun getBrazil(): LiveData<List<StatesBrResponse>> {
        val result = MutableLiveData<List<StatesBrResponse>>()

        ApiService.service.getBrazil().enqueue(object : Callback<GenericResponse<StatesBrResponse>>{
            override fun onFailure(call: Call<GenericResponse<StatesBrResponse>>, t: Throwable) {
                result.value = null
            }

            override fun onResponse(
                call: Call<GenericResponse<StatesBrResponse>>,
                response: Response<GenericResponse<StatesBrResponse>>
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
