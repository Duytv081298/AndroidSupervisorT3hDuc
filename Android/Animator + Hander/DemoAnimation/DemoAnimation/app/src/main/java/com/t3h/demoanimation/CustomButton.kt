package com.t3h.demoanimation

import android.content.Context
import android.support.v7.widget.AppCompatButton
import android.util.AttributeSet
import android.util.Log

class CustomButton : AppCompatButton {
    constructor(context: Context?, attrs: AttributeSet?) :
            super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) :
            super(context, attrs, defStyleAttr)

    fun setAhihi(value:Float){
        Log.d("CustomButton", "setAhihi value: " + value)
//        x=value
    }

    fun setTestHello(v:Float){
        x = v
        y = v
    }
}