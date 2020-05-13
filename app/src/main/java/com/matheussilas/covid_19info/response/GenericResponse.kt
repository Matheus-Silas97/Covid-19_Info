package com.matheussilas.covid_19info.response

import com.google.gson.annotations.SerializedName

class  GenericResponse <T> {

    @SerializedName("data")
     var data: List<T>? = null

}