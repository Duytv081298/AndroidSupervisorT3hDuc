package com.t3h.areadata

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.t3h.areadata.databinding.ItemImageBinding
import java.io.File

class ImageAdapter : RecyclerView.Adapter<ImageAdapter.ImageViewHolder> {
    private lateinit var paths: MutableList<String>

    constructor(paths: MutableList<String>) {
        this.paths = paths
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        return ImageViewHolder(
            ItemImageBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    override fun getItemCount() = paths.size

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
       Glide.with(holder.binding.ivImg)
           .load(File(paths[position]))
           .into(holder.binding.ivImg)
    }

    class ImageViewHolder(val binding: ItemImageBinding) : RecyclerView.ViewHolder(binding.root) {

    }
}