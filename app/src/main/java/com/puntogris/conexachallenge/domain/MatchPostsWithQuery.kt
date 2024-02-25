package com.puntogris.conexachallenge.domain

import javax.inject.Inject

class MatchPostsWithQuery @Inject constructor() {
    operator fun invoke(posts: List<Post>, query: String): List<Post> {

        if (query.isEmpty()) {
            return posts
        }

        return posts.filter {
            it.title.contains(query, true) || it.content.contains(query, true)
        }
    }
}