package com.matheussilas.covid_19info

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiService {
    var retrofit: Retrofit? = null
    private val retrofitInstance: Retrofit?
        get() {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl("https://covid19-brazil-api.now.sh")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit
        }

    val service: CovidServices = retrofitInstance!!.create(CovidServices::class.java)
}
