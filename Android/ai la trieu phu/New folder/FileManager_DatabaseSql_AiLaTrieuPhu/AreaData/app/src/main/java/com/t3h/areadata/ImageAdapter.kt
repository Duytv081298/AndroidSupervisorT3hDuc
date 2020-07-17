package com.t3h.areadata

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.t3h.areadata.databinding.ItemImageBinding
import java.io.File

class ImageAdapter : RecyclerView.Adapter<ImageAdapter.ImageViewHolder> {
    //    private lateinit var paths: MutableList<String>
    private lateinit var inter: IImageAdapter

    constructor(inter: IImageAdapter) {
        this.inter = inter
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        return ImageViewHolder(
            ItemImageBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    override fun getItemCount() = inter.size()

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        Glide.with(holder.binding.ivImg)
            .load(File(inter.getItem(position)))
            .into(holder.binding.ivImg)
        holder.binding.ivImg.setOnClickListener {
            inter.onClick(position, holder.binding.ivImg)
        }
    }

    class ImageViewHolder(val binding: ItemImageBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    interface IImageAdapter {
        fun onClick(position: Int, v: View)
        fun getItem(position: Int): String
        fun size(): Int
    }

}