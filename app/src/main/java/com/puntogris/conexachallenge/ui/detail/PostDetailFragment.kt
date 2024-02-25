package com.puntogris.conexachallenge.ui.detail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.puntogris.conexachallenge.R
import com.puntogris.conexachallenge.databinding.FragmentPostDetailBinding
import com.puntogris.conexachallenge.domain.Post
import com.puntogris.conexachallenge.utils.viewBinding

class PostDetailFragment : Fragment(R.layout.fragment_post_detail) {

    private val binding by viewBinding(FragmentPostDetailBinding::bind)

    private val args : PostDetailFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupViews(args.post)
    }

    private fun setupViews(post: Post) {
        with(binding) {
            tvTitle.text = post.title
            tvContent.text = post.content
            Glide.with(requireContext())
                .load(post.image)
                .transform(RoundedCorners(10))
                .into(ivImage)
        }
    }
}