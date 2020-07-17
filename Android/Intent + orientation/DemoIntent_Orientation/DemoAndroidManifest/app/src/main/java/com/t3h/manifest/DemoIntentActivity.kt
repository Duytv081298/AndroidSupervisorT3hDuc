package com.t3h.manifest

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_demo_intent.*

/**
 * Created by GiangVien T3H on 2/12/2020.
 */
class DemoIntentActivity : AppCompatActivity(), View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demo_intent)
        btnCall.setOnClickListener(this)
    }
    override fun onClick(v: View) {
        when(v.id){
            R.id.btnCall->{
                val phoneNumber = edtPhoneNumber.text.toString()
                val intent = Intent()
//                intent.setAction(Intent.ACTION_CALL)
                intent.setAction("android.intent.action.CALL")
                intent.data = Uri.parse("tel:"+phoneNumber)
                startActivity(intent)

            }
        }
    }
}