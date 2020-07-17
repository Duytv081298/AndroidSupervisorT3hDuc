package com.t3h.demorecycleview

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.t3h.demorecycleview.databinding.ItemRssBinding

class RssAdapter : RecyclerView.Adapter<RssAdapter.RssViewHolder> {
    private var rssDatas: MutableList<RssData>

    constructor(rssDatas: MutableList<RssData>) {
        this.rssDatas = rssDatas
    }

    //tao viewholder
    override fun onCreateViewHolder(group: ViewGroup, type: Int): RssViewHolder {
        //lay context tu group vi
        //+ tat ca cac loai view deu co context
        // +vi co context moi hien thi duoc
        val binding: ItemRssBinding = ItemRssBinding.inflate(
                LayoutInflater.from(group.context),
                group,
                false
        )

//        val itemView = LayoutInflater.from(group.context).inflate(
//                R.layout.item_rss, group, false
//        )
        return RssViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return rssDatas.size
    }

    //do du lieu len itemview(viewholder)
    override fun onBindViewHolder(holder: RssViewHolder, position: Int) {
        //do du lieu len xml
        holder.binding.itemData = rssDatas.get(position)
        if (rssDatas.get(position).isClick) {


            holder.itemView.setBackgroundColor(Color.BLUE)
        } else {
            holder.itemView.setBackgroundColor(Color.TRANSPARENT)
        }

        holder.itemView.setOnClickListener({
            rssDatas.get(position).isClick = !rssDatas.get(position).isClick
            //reload lai item view nay -> sex tu dong goi onBindViewHolder voi vi tri la
            //position
            notifyItemChanged(position)
        })
    }

    class RssViewHolder : RecyclerView.ViewHolder {
        val binding: ItemRssBinding

        constructor(binding: ItemRssBinding) : super(binding.root) {
            this.binding = binding
        }

    }
}
