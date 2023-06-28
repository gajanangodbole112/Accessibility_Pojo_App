package com.gajanan.pojoapp.presentation.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.gajanan.pojoapp.data.repository.PostRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PostViewModel @Inject constructor(
    repo: PostRepository
) : ViewModel() {
    val posts = repo.getPosts().asLiveData()
}