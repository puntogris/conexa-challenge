package com.puntogris.conexachallenge.data.models

import com.google.gson.annotations.SerializedName

data class GeoDto(
    @SerializedName("lat")
    val lat: String,

    @SerializedName("lng")
    val lng: String
)