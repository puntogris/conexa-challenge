package com.puntogris.conexachallenge.ui.users

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.puntogris.conexachallenge.R
import com.puntogris.conexachallenge.databinding.FragmentUsersBinding
import com.puntogris.conexachallenge.domain.User
import com.puntogris.conexachallenge.utils.Resource
import com.puntogris.conexachallenge.utils.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class UsersFragment : Fragment(R.layout.fragment_users) {

    private val binding by viewBinding(FragmentUsersBinding::bind)

    private val viewModel by viewModels<UsersViewModel>()

    private val adapter by lazy { UsersAdapter(::onUserClicked) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupViews()
        setupObservers()
    }

    private fun setupViews() {
        binding.rvUsers.adapter = adapter
    }

    private fun setupObservers() {
        lifecycleScope.launch {
            viewModel.users.collectLatest { result ->
                onUsersResult(result)
            }
        }
    }

    private fun onUsersResult(result: Resource<List<User>>) {
        when (result) {
            is Resource.Error -> {
                Snackbar.make(binding.root, result.error, Snackbar.LENGTH_LONG).show()
                binding.pbLoading.isVisible = false
            }

            is Resource.Loading -> {
                binding.pbLoading.isVisible = true
            }

            is Resource.Success -> {
                adapter.submitList(result.value)
                binding.pbLoading.isVisible = false
            }
        }
    }

    private fun onUserClicked(user: User) {
        val action = UsersFragmentDirections.actionUsersFragmentToMapFragment(user.lat, user.lng)
        findNavController().navigate(action)
    }
}
