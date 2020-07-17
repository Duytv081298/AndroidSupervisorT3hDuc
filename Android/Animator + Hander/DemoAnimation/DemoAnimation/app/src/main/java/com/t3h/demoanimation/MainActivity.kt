package com.t3h.demoanimation

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.*
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener, Animation.AnimationListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnTranslate.setOnClickListener(this)
        btnAlpha.setOnClickListener(this)
        btnRotate.setOnClickListener(this)
        btnScale.setOnClickListener(this)
        btnSet.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btnTranslate -> {
//                var an:TranslateAnimation =
//                AnimationUtils.loadAnimation(this,
//                        R.anim.demo_translate) as TranslateAnimation
//
//                ivImage.animation = an
//                ivImage.startAnimation(an)
                setMakeObjectAnimator(1f)

            }
            R.id.btnAlpha -> {
                var an =
                        AnimationUtils.loadAnimation(this,
                                R.anim.demo_alpha) as AlphaAnimation

                ivImage.animation = an
                ivImage.startAnimation(an)

            }
            R.id.btnRotate -> {
                var an =
                        AnimationUtils.loadAnimation(this,
                                R.anim.demo_rotate) as RotateAnimation

                ivImage.animation = an
                ivImage.startAnimation(an)

            }
            R.id.btnScale -> {
                var an =
                        AnimationUtils.loadAnimation(this,
                                R.anim.demo_scale) as ScaleAnimation

                ivImage.animation = an
                ivImage.startAnimation(an)

            }
            R.id.btnSet -> {
                var an =
                        AnimationUtils.loadAnimation(this,
                                R.anim.demo_set) as AnimationSet
                //bat cac event cua animation
                an.setAnimationListener(object : Animation.AnimationListener {
                    override fun onAnimationRepeat(p0: Animation?) {
//                        Toast.makeText(baseContext, "onAnimationRepeat",
//                                Toast.LENGTH_SHORT).show()
                    }

                    override fun onAnimationEnd(p0: Animation?) {
//                        Toast.makeText(baseContext, "onAnimationEnd",
//                                Toast.LENGTH_SHORT).show()
                    }

                    override fun onAnimationStart(p0: Animation?) {
//                        Toast.makeText(baseContext, "onAnimationStart",
//                                Toast.LENGTH_SHORT).show()
                    }
                })

                ivImage.animation = an
                ivImage.startAnimation(an)

            }
        }
    }

    override fun onAnimationRepeat(p0: Animation?) {
    }

    override fun onAnimationEnd(p0: Animation?) {
    }

    override fun onAnimationStart(p0: Animation?) {
    }

    public fun setMakeObjectAnimator(t:Float) {
        val ani = ObjectAnimator.ofFloat(btnTranslate, "testHello",
                0f, 1000f, 200f, 800f
        )
        ani.duration = 2000

        val aniY = ObjectAnimator.ofFloat(btnTranslate, "y",
                0f, 1000f, 200f, 800f
        )
        ani.duration = 2000


        val set = AnimatorSet()
        set.playTogether(ani, aniY)
        set.start()

    }

}
