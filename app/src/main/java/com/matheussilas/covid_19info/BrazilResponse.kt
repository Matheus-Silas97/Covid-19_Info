package com.matheussilas.covid_19info

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class BrazilResponse(
    @SerializedName("uf")
    val state: String,

    @SerializedName("cases")
    @Expose
    val cases: Int,

    @SerializedName("suspects")
    @Expose
    val suspects: Int,

    @SerializedName("deaths")
    val deaths: Int

)