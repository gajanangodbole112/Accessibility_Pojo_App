package com.gajanan.pojoapp.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.gajanan.pojoapp.data.modals.Post
import com.gajanan.pojoapp.databinding.FragmentPostBinding
import com.gajanan.pojoapp.presentation.adapters.PostAdapter
import com.gajanan.pojoapp.presentation.viewModels.PostViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class PostFragment : Fragment(), PostAdapter.PostClickListener {

    private lateinit var binding: FragmentPostBinding
    private val postViewModel: PostViewModel by viewModels()

    private lateinit var navController: NavController
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentPostBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        observers()
    }

    private fun observers() = with(binding) {
        postViewModel.posts.observe(viewLifecycleOwner) {
            rvPosts.adapter = PostAdapter(it.data!!, this@PostFragment)
            rvPosts.addItemDecoration(
                DividerItemDecoration(
                    requireContext(),
                    LinearLayoutManager.VERTICAL
                )
            )
        }
    }

    override fun onPostClick(item: Post) {
        val action = PostFragmentDirections.actionPostFragmentToPostDetailFragment(
            item
        )
        navController.navigate(action)
    }
}