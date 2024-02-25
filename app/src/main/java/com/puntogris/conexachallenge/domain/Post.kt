package com.puntogris.conexachallenge.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Post(
    val title: String,
    val content: String,
    val image: String
): Parcelable