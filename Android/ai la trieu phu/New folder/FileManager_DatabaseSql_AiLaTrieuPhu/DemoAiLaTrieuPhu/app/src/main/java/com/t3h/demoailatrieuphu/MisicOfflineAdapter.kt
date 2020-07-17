package com.t3h.demoailatrieuphu

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.t3h.demoailatrieuphu.databinding.MediaplayerBinding

class MusicOfflineAdapter(val inter:IMusic) : RecyclerView.Adapter<MusicOfflineAdapter.MusicViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, type: Int): MusicViewHolder {
        return MusicViewHolder(
            MediaplayerBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    override fun getItemCount()=inter.getCount()

    override fun onBindViewHolder(holder: MusicViewHolder, position: Int) {
    }
    interface IMusic{
        fun onItemClick(position:Int)
        fun getItem(position: Int):ItemMusicOffline
        fun getCount():Int
    }

    class MusicViewHolder(val binding:MediaplayerBinding) : RecyclerView.ViewHolder(binding.root)
}