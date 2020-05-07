package com.matheussilas.covid_19info

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface CovidServices {

    @GET("/api/report/v1")
    fun getBrazil(): Call <GenericResponse<BrazilResponse>>
}