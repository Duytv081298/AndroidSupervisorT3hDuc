package com.t3h.areadata

import android.content.Context
import android.content.SharedPreferences
import android.database.DatabaseUtils
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.t3h.areadata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        inits()
        binding.btnLogin.setOnClickListener {
            val share = this@MainActivity.getSharedPreferences(
                "app",
                Context.MODE_PRIVATE
            )
            //bat dau transaction de ghi dl
            val edt = share.edit()
            edt.putString("username", binding.edtUserName.text.toString())
            edt.putString("password", binding.edtPassword.text.toString())
            //commit
            edt.apply()

            Toast.makeText(this@MainActivity,
            "Finish", Toast.LENGTH_LONG).show()
        }
    }

    private fun inits(){
        binding.edtUserName.setText(
            getSharedPreferences("app", Context.MODE_PRIVATE)
                .getString("username", "")
        )
        binding.edtPassword.setText(
            getSharedPreferences("app", Context.MODE_PRIVATE)
                .getString("password", "")
        )
    }
}
