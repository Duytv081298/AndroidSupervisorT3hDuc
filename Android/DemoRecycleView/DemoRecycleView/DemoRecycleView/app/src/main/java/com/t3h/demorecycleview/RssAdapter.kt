package com.t3h.demorecycleview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

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
        val itemView = LayoutInflater.from(group.context).inflate(
                R.layout.item_rss, group, false
        )
        return RssViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return rssDatas.size
    }

    //do du lieu len itemview(viewholder)
    override fun onBindViewHolder(holder: RssViewHolder, position: Int) {
        val data = rssDatas.get(position)
        holder.tvTitle.text=data.title
        holder.tvDesciption.text=data.description

        Glide.with(holder.ivImg)
                .load(data.img)
                .placeholder(R.drawable.aodai)
                .error(R.drawable.aodai)
                .into(holder.ivImg)
    }

    class RssViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var ivImg: ImageView
        var tvTitle: TextView
        var tvDesciption: TextView

        init {
            ivImg = itemView.findViewById(R.id.iv_img)
            tvTitle = itemView.findViewById(R.id.tv_title)
            tvDesciption = itemView.findViewById(R.id.tv_description)
        }
    }
}
