package com.matheussilas.covid_19info.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class CountryResponse (
    @SerializedName("country")
    @Expose
    val country: String,

    @SerializedName ("cases")
    @Expose
    val cases: Int,

    @SerializedName("confirmed")
    @Expose
    val confirmed: Int,

    @SerializedName("deaths")
    @Expose
    val deaths: Int,

    @SerializedName("recovered")
    @Expose
    val recovered: Int
)