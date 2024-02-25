package com.puntogris.conexachallenge.ui.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.puntogris.conexachallenge.R
import com.puntogris.conexachallenge.databinding.FragmentSearchBinding
import com.puntogris.conexachallenge.databinding.ItemSearchBinding
import com.puntogris.conexachallenge.domain.Post
import com.puntogris.conexachallenge.utils.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SearchFragment : Fragment(R.layout.fragment_search) {

    private val binding by viewBinding(FragmentSearchBinding::bind)

    private val viewModel by viewModels<SearchViewModel>()

    private val adapter by lazy { SearchAdapter(::onPostClicked) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupViews()
        setupObservers()
        setupListeners()
    }

    private fun setupViews() {
        binding.rvSearch.adapter = adapter
    }

    private fun setupObservers() {
        lifecycleScope.launch {
            viewModel.postToShow.collectLatest {
                adapter.submitList(it)
            }
        }
    }

    private fun setupListeners() {
        binding.etSearch.addTextChangedListener {
            viewModel.setQuery(it.toString())
        }
    }

    private fun onPostClicked(post: Post) {
        val action = SearchFragmentDirections.actionSearchFragmentToPostDetailFragment(post)
        findNavController().navigate(action)
    }
}
