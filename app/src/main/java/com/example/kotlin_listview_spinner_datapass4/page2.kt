package com.example.kotlin_listview_spinner_datapass4

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class page2 : AppCompatActivity() {

    lateinit var tvName : TextView
    lateinit var tvRoll: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_page2)
        tvName = findViewById(R.id.tv_lv_data_show)
        tvRoll= findViewById(R.id.tv_sp_data_show)

        val bundle = intent.extras
        if (bundle != null){

            tvName.text = "Name = ${bundle.getString("name")}"
            tvRoll.text = "RollNo = ${bundle.getString("roll")}"

        }
    }
}