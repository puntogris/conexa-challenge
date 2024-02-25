package com.puntogris.conexachallenge.data.models

import com.google.gson.annotations.SerializedName

data class PostDto(
    @SerializedName("id")
    val id: Int,

    @SerializedName("slug")
    val slug: String,

    @SerializedName("url")
    val url: String,

    @SerializedName("title")
    val title: String,

    @SerializedName("content")
    val content: String,

    @SerializedName("image")
    val image: String,

    @SerializedName("thumbnail")
    val thumbnail: String,

    @SerializedName("status")
    val status: String,

    @SerializedName("category")
    val category: String,

    @SerializedName("publishedAt")
    val publishedAt: String,

    @SerializedName("updatedAt")
    val updatedAt: String,

    @SerializedName("userId")
    val userId: Int
)