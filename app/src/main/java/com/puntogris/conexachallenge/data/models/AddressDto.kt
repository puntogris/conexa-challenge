package com.puntogris.conexachallenge.data.models

import com.google.gson.annotations.SerializedName

data class AddressDto(
    @SerializedName("street")
    val street: String,

    @SerializedName("suite")
    val suite: String,

    @SerializedName("city")
    val city: String,

    @SerializedName("zipcode")
    val zipcode: String,

    @SerializedName("geo")
    val geo: GeoDto
)