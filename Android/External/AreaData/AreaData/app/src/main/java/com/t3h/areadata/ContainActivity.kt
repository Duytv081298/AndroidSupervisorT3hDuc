package com.t3h.areadata

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class ContainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contain)

        supportFragmentManager.beginTransaction()
            .add(R.id.content, MainFragment(), MainFragment::class.java.name)
            .commit()
    }

    fun openGalleryFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.content, GalleryFragment(), GalleryFragment::class.java.name)
            .addToBackStack(null)
            .commit()
    }

}