package com.codefood.kitchen.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        button.setOnClickListener {
            EmptyBottomSheet().show(supportFragmentManager, "empty_sheet")
        }
    }
}
