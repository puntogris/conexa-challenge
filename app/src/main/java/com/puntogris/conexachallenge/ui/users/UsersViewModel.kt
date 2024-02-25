package com.puntogris.conexachallenge.ui.users

import androidx.lifecycle.ViewModel
import com.puntogris.conexachallenge.domain.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UsersViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    val users = repository.getUsers()
}