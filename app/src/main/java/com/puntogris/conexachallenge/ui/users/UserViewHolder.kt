package com.puntogris.conexachallenge.ui.users

import android.text.SpannableStringBuilder
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.text.bold
import androidx.recyclerview.widget.RecyclerView
import com.puntogris.conexachallenge.databinding.ItemUserBinding
import com.puntogris.conexachallenge.domain.User

class UserViewHolder(private val binding: ItemUserBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(user: User, onClick: (User) -> Unit) {
        binding.tvFullName.text = SpannableStringBuilder().apply {
            append(user.firstname)
            appendLine()
            bold {
                append(user.lastname)
            }
        }
        binding.tvEmail.text = user.email
        binding.root.setOnClickListener {
            onClick(user)
        }
    }

    companion object {
        fun from(parent: ViewGroup): UserViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = ItemUserBinding.inflate(layoutInflater, parent, false)
            return UserViewHolder(binding)
        }
    }
}