package com.t3h.manifest

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity(), View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        val username = intent.getStringExtra("username")
        edtUsername.setText(username)
        val password = intent.getStringExtra("password")
        edtPassword.setText(password)

        btnRegister.setOnClickListener(this)

    }

    override fun onClick(v: View) {
        val intent = Intent()
        //dua du lieu vao
        //khong xac diem den vi: di nhu the nao, se ve nhu the
        intent.putExtra("username", edtUsername.text.toString())
        //cho intent chay
        setResult(Activity.RESULT_OK, intent)
        //ket thuc
        finish()
    }
}
