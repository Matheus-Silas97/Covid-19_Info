package com.matheussilas.covid_19info

import com.matheussilas.covid_19info.response.CountryResponse
import com.matheussilas.covid_19info.response.StatesBrResponse
import com.matheussilas.covid_19info.response.GenericResponse
import retrofit2.Call
import retrofit2.http.GET

interface CovidServices {

    @GET("/api/report/v1")
    fun getBrazil(): Call<GenericResponse<StatesBrResponse>>

   @GET("/api/report/v1/countries")
   fun getCountry(): Call<GenericResponse<CountryResponse>>


}