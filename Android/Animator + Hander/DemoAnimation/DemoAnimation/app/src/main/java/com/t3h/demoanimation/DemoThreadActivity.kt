package com.t3h.demoanimation

import android.os.AsyncTask
import android.os.Bundle
import android.os.Handler
import android.os.SystemClock
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.actvity_demo_thread.*

class DemoThreadActivity :AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.actvity_demo_thread)
        btnStart.setOnClickListener {
            demoAsyn()
        }

        demoHander()
    }

    fun demoAsyn(){
        val asy = object :AsyncTask<Int, String, String>(){
            override fun doInBackground(vararg ps: Int?): String? {
                //se thuc hien tren thread khac
                for (i in 0..ps[0]!!){
                    SystemClock.sleep(100)
                    //se chay xuong onProgressUpdate
                    publishProgress(i.toString())
                }
                return "Finish"
            }

            override fun onProgressUpdate(vararg values: String?) {
                tvNumber.setText(values[0])
            }

            override fun onPostExecute(result: String?) {
                tvNumber.setText(result)
            }
        }

        asy.execute(200)
    }

    public fun demoHander(){
//        Handler().postDelayed(object :Runnable{
//            override fun run() {
//
//            }
//        }, 100)

        Handler().postDelayed({
            tvNumber.setText("Finish Handler")
        }, 10000)
    }
}