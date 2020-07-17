package com.t3h.demoailatrieuphu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var database:SqlALTPManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        database = SqlALTPManager(this)
        btn_click.setOnClickListener {
            database.query15Question()
        }
    }
}
