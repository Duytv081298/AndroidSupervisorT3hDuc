package com.t3h.demoailatrieuphu

import android.media.MediaPlayer
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.t3h.demoailatrieuphu.R

class DemoMediaInternal : AppCompatActivity(){
    private  var mp:MediaPlayer? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mp
        MediaPlayer.create(this, R.raw.hoi_y_kien_chuyen_gia_01b)
        mp?.start()
    }

    override fun onDestroy() {

        //khi không sử dụng thì giải phóng mediaplayer
        mp?.release()
        super.onDestroy()
    }
}