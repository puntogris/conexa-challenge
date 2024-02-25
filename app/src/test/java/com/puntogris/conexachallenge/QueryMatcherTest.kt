package com.puntogris.conexachallenge

import com.puntogris.conexachallenge.domain.MatchPostsWithQuery
import com.puntogris.conexachallenge.domain.Post
import org.junit.Test

import org.junit.Assert.*

class QueryMatcherTest {

    private val postOne = Post(
        title = "Post 1",
        content = "Content 1",
        image = ""
    )

    private val postTwo = Post(
        title = "Post 2",
        content = "Content 2",
        image = ""
    )

    private val allPosts: List<Post> = listOf(postOne, postTwo)

    private val matcher = MatchPostsWithQuery()

    @Test
    fun `query should not match any posts`() {
        val query = "post 3"

        val result = matcher(allPosts, query)

        assertEquals(result, emptyList<Post>())
    }

    @Test
    fun `query should match all posts`() {
        val queryOne = ""
        val queryTwo = "post"

        val resultOne = matcher(allPosts, queryOne)
        val resultTwo = matcher(allPosts, queryTwo)

        assertEquals(resultOne, allPosts)
        assertEquals(resultTwo, allPosts)
    }
    
    @Test
    fun `query should only match post 1`() {
        val query = "post 1"

        val result = matcher(allPosts, query)

        assertEquals(result, listOf(postOne))
    }

    @Test
    fun `query should only match post 2`() {
        val query = "Content 2"

        val result = matcher(allPosts, query)

        assertEquals(result, listOf(postTwo))
    }
}