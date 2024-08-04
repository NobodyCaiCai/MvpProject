package com.caicai.mvpstudyproject.mvp.v3.a_demo.demo4

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.caicai.mvpstudyproject.R

class ShellActivityV2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shell)
        supportFragmentManager.beginTransaction().replace(R.id.content, Demo4Fragment()).commit()
    }
}