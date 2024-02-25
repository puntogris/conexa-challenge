package com.puntogris.conexachallenge.ui.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.puntogris.conexachallenge.databinding.ItemSearchBinding
import com.puntogris.conexachallenge.domain.Post

class SearchViewHolder(private val binding: ItemSearchBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(post: Post, onClick: (Post) -> Unit) {
        with(binding) {
            tvTitle.text = post.title
            tvContent.text = post.content
            root.setOnClickListener {
                onClick(post)
            }
            Glide.with(ivImage)
                .load(post.image)
                .transform(RoundedCorners(10))
                .into(ivImage)
        }
    }

    companion object {
        fun from(parent: ViewGroup): SearchViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = ItemSearchBinding.inflate(layoutInflater, parent, false)
            return SearchViewHolder(binding)
        }
    }
}