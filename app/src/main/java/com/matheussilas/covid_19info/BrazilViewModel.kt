package com.matheussilas.covid_19info

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BrazilViewModel : ViewModel() {
    fun brazilInfo(): LiveData<List<BrazilResponse>> {
        return getBrazil()
    }

    private fun getBrazil(): LiveData<List<BrazilResponse>> {
        val result = MutableLiveData<List<BrazilResponse>>()

        ApiService.service.getBrazil().enqueue(object : Callback<GenericResponse<BrazilResponse>>{
            override fun onFailure(call: Call<GenericResponse<BrazilResponse>>, t: Throwable) {
                result.value = null
            }

            override fun onResponse(
                call: Call<GenericResponse<BrazilResponse>>,
                response: Response<GenericResponse<BrazilResponse>>
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
