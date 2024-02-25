package com.puntogris.conexachallenge.data.utils

import com.puntogris.conexachallenge.data.models.PostDto
import com.puntogris.conexachallenge.data.models.UserDto
import com.puntogris.conexachallenge.domain.Post
import com.puntogris.conexachallenge.domain.User

fun PostDto.toDomain(): Post {
    return Post(
        title = title,
        content = content,
        image = image
    )
}

fun UserDto.toDomain(): User {
    return User(
        firstname = firstname,
        lastname = lastname,
        email = email,
        lat = address.geo.lat,
        lng = address.geo.lng
    )
}