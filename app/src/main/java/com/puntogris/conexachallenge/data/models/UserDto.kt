package com.puntogris.conexachallenge.data.models

import com.google.gson.annotations.SerializedName

data class UserDto(
    @SerializedName("id")
    val id: Int,

    @SerializedName("firstname")
    val firstname: String,

    @SerializedName("lastname")
    val lastname: String,

    @SerializedName("email")
    val email: String,

    @SerializedName("birthDate")
    val birthDate: String,

    @SerializedName("address")
    val address: AddressDto,

    @SerializedName("phone")
    val phone: String,

    @SerializedName("website")
    val website: String
)