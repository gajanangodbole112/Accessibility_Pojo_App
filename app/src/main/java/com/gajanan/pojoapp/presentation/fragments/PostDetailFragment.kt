package com.gajanan.pojoapp.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.gajanan.pojoapp.databinding.FragmentPostDetailBinding


class PostDetailFragment : Fragment() {
    private lateinit var binding: FragmentPostDetailBinding
    private val args by navArgs<PostDetailFragmentArgs>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentPostDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() = with(binding) {
        tvTitle.text = args.post.title
        tvBody.text = args.post.body
        tvUserId.text = "User Id : ${args.post.userId}"
    }
}