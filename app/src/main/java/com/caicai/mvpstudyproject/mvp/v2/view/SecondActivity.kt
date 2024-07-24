package com.caicai.mvpstudyproject.mvp.v2.view

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.caicai.mvpstudyproject.R

class SecondActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("==========", "SecondActivity1")
        setContentView(R.layout.activity_second)
        Log.i("==========", "SecondActivity2")
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, SecondFragment()).commit()
    }
}