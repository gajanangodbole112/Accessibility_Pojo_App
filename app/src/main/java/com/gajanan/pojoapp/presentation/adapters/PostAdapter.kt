package com.gajanan.pojoapp.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gajanan.pojoapp.data.modals.Post
import com.gajanan.pojoapp.databinding.ItemsOfPostBinding

class PostAdapter(
    private val postList: List<Post>,
    private val onPostClick: PostClickListener
) : RecyclerView.Adapter<PostAdapter.PostVH>() {
    inner class PostVH(private val binding: ItemsOfPostBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(items: Post) {
            binding.tvTitle.text = items.title

            itemView.setOnClickListener {
                onPostClick.onPostClick(items)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostVH = PostVH(
        ItemsOfPostBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: PostVH, position: Int) {
       val postItems = postList[position]
        holder.bind(postItems)
    }

    override fun getItemCount(): Int = postList.size


    interface PostClickListener{
        fun onPostClick(item : Post)
    }

}
