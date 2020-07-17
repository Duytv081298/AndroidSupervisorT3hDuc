package com.t3h.manifest

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    companion object {
        val TAG = "MainActivity"
    }
//    private lateinit var edtUser:EditText
//    private  var edtUser:EditText?=null
//    private  var edtPassword:EditText?=null
//    private  var btnLogin:Button?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        edtUser = findViewById(R.id.edtUsername)
//        edtPassword = findViewById(R.id.edtPassword)
        //cach 1 set onclick
//        btnLogin.setOnClickListener(this)


//        v.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });
        btnLogin.setOnClickListener({
            //vao day
            //hien thi thong bao
            Toast.makeText(this, "Click login", Toast.LENGTH_SHORT).show()
            //mo activity khac
            val intent = Intent()
            intent.setClass(this, OtherActivity::class.java)
            startActivity(intent)
        })
        val a = 3/0
        Log.d(TAG, "onCreate ten bien + gia tri bien")
    }

    override fun onClick(v: View) {

    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume ten bien + gia tri bien")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause ten bien + gia tri bien")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy ten bien + gia tri bien")
    }

}
