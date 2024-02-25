package com.puntogris.conexachallenge.ui.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.puntogris.conexachallenge.domain.MatchPostsWithQuery
import com.puntogris.conexachallenge.domain.Repository
import com.puntogris.conexachallenge.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    repository: Repository,
    private val matchPostsWithQuery: MatchPostsWithQuery
) : ViewModel() {

    private val searchQuery = MutableStateFlow("")

    val postToShow = combine(repository.getPosts(), searchQuery) { posts, query ->
        matchPostsWithQuery(
            posts = if (posts is Resource.Success) posts.value else emptyList(),
            query = query
        )
    }

    fun setQuery(newQuery: String) {
        viewModelScope.launch {
            searchQuery.emit(newQuery)
        }
    }
}
