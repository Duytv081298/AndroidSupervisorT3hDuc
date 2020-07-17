package com.t3h.areadata

import android.os.Bundle
import android.transition.Fade
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.fragment.app.Fragment


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
            .hide(supportFragmentManager.findFragmentByTag(MainFragment::class.java.name)!!)
            .add(R.id.content, GalleryFragment(), GalleryFragment::class.java.name)
            .addToBackStack(null)
            .commit()
    }

    fun openImageDetailFragment(
        path: String, fragmentExit: Fragment,
        ivShare: View
    ) {
        val bu = Bundle()
        bu.putString("PATH", path)

        val fg = ImageDetailFragment()
        //de dua bundle vao trong fragment
        fg.arguments = bu
        fg.setSharedElementEnterTransition(DetailsTransition())
        fg.setEnterTransition(Fade())
        fragmentExit.setExitTransition(Fade())
        fg.setSharedElementReturnTransition(DetailsTransition())
        ViewCompat.setTransitionName(ivShare, "IV")
        supportFragmentManager.beginTransaction()
            .addSharedElement(ivShare, "IV")
            .hide(supportFragmentManager.findFragmentByTag(GalleryFragment::class.java.name)!!)
            .add(R.id.content, fg, ImageDetailFragment::class.java.name)
            .addToBackStack(null)
            .commit()
    }
}