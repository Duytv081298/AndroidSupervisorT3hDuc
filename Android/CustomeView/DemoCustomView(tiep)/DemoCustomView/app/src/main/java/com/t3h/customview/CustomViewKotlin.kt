package com.t3h.customview

import android.content.Context
import android.graphics.*
import android.os.SystemClock
import android.util.AttributeSet
import android.view.View
import java.text.SimpleDateFormat
import java.util.*

class CustomViewKotlin : View {
    //    var isRunningTime: Boolean = true
    private var isRunningTime = false
    private var colorSmile = 0

    constructor(c: Context, attrs: AttributeSet)
            : super(c, attrs) {
        extractAtt(attrs)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int)
            : super(context, attrs, defStyleAttr) {
        extractAtt(attrs!!)

    }

    private fun extractAtt(atts: AttributeSet) {
        //lay tat ca cac thuoc tinh trong xml ra
        val customXml = context.obtainStyledAttributes(
                atts, R.styleable.CustomViewKotlin)

        //lay tung gia tri cac thuoc tinh trong xml da khai bao
        colorSmile =
                customXml.getColor(R.styleable.CustomViewKotlin_colorSmile,
                        Color.parseColor("#F44336"))

        customXml.recycle()
    }


    //    @Override
//    protected void onDraw(Canvas canvas) {
//        super.onDraw(canvas);
//    }
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
//        Paint p = new Paint();
        var p = Paint()
        p.style = Paint.Style.STROKE
        p.isAntiAlias = true
        p.color = Color.parseColor("#673AB7")
        p.strokeWidth = 15.0f
        canvas.drawCircle(width.toFloat() / 2, height.toFloat() / 2,
                width.toFloat() / 2 - 7.5f, p)


        p.textSize = 72.0f
        p.color = colorSmile

        val bound = Rect()
        p.getTextBounds("SMILE", 0, "SMILE".length, bound)
        canvas.drawText("SMILE", (width - bound.width())/2.0f, 100.0f, p)

        //draw date
        val currentDate = Date() //lay thoi gian hien tai cua dien thoai
        val formatTime = SimpleDateFormat("HH:mm:ss")
        val textTime = formatTime.format(currentDate)

        p.color = Color.parseColor("#2196F3")
        canvas.drawText(textTime, 130.0f, 200.0f, p)

        val formatDate = SimpleDateFormat("dd/MM/yyyy")
        p.textSize = 50.0f
        p.setTypeface(Typeface.DEFAULT_BOLD)

        canvas.drawText(formatDate.format(currentDate),
                130.0f, 300.0f, p)

        //chuyen anh trong drawable thanh Bitmap
        val bm = BitmapFactory.decodeResource(
                resources, R.drawable.clock
        )
        val retRes = Rect(0, 0, bm.width, bm.height)
        val retDes = Rect(180, 350, 180 + 130, 350 + 130)
        canvas.drawBitmap(bm, retRes, retDes, null)

    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        createThread()
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        isRunningTime = false
    }

    private fun createThread() {
//        IClock c = new IClock() {
//            @Override
//            public void test() {
//
//            }
//        };
        isRunningTime = true
        val run = Runnable {
            while (isRunningTime) {
//                invalidate()//==repaint trong java
                postInvalidate()
                SystemClock.sleep(1000)
            }
        }
        var th = Thread(run)
        th.start()
    }
}