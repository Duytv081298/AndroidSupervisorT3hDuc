package com.t3h.demoailatrieuphu

import android.os.Binder
import android.os.Bundle
import android.provider.MediaStore
import androidx.appcompat.app.AppCompatActivity
import com.t3h.demoailatrieuphu.databinding.MediaplayerBinding

class DemoMediaActivity:  AppCompatActivity(){
    private lateinit var binding: MediaplayerBinding
    private var musicOfflines = mutableListOf<ItemMusicOffline>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getAllMusic()
        binding
    }
    private fun getAllMusic() {
        var uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI
        var c = contentResolver.query(uri, null,null,null,null)
        c?.moveToFirst()
        val indexData = c.getColumnIndex("_data");
        val indexTitle = c.getColumnIndex("_display_name");
        val indexAlbumId = c.getColumnIndex("album_id");
        val indexDuration = c.getColumnIndex("duration");
        while (!c.isAfterLast) {
            val data = c.getString(indexData);
            val title = c.getString(indexTitle);
            val albumTitle = c.getString(indexAlbumId);
            val duration = c.getLong(indexDuration);
            musicOfflines.add(
                ItemMusicOffline(data, title, null, duration)
            )
        }
    }
}