package com.codefood.kitchen

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        try {
            findNavController(R.id.fragment).navigate(R.id.homeActivity)
        } catch (e: Throwable) {
            e.printStackTrace()
        }
    }
}
