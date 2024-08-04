package com.caicai.mvpstudyproject.mvp.v3.a_demo

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

import com.caicai.mvpstudyproject.R
import com.caicai.mvpstudyproject.mvp.v3.a_demo.demo1.SimpleActivity
import com.caicai.mvpstudyproject.mvp.v3.a_demo.demo2.DemoActivityV2
import com.caicai.mvpstudyproject.mvp.v3.a_demo.demo3.ShellActivity
import com.caicai.mvpstudyproject.mvp.v3.a_demo.demo4.ShellActivityV2
import com.caicai.mvpstudyproject.mvp.v3.a_demo.demo5.Demo5Activity
import com.caicai.mvpstudyproject.mvp.v3.a_demo.demo6.Demo6Activity

class TheMVPActivity: AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_the_mvp)
        findViewById<Button>(R.id.button_mvp1).setOnClickListener(this)
        findViewById<Button>(R.id.button_mvp2).setOnClickListener(this)
        findViewById<Button>(R.id.button_mvp3).setOnClickListener(this)
        findViewById<Button>(R.id.button_mvp4).setOnClickListener(this)
        findViewById<Button>(R.id.button_mvp5).setOnClickListener(this)
        findViewById<Button>(R.id.button_mvp6).setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val id = v?.id
        when (id) {
            R.id.button_mvp1 -> startActivity(Intent(this, SimpleActivity::class.java))
            R.id.button_mvp2 -> startActivity(Intent(this, DemoActivityV2::class.java))
            R.id.button_mvp3 -> startActivity(Intent(this, ShellActivity::class.java))
            R.id.button_mvp4 -> startActivity(Intent(this, ShellActivityV2::class.java))
            R.id.button_mvp5 -> startActivity(Intent(this, Demo5Activity::class.java))
            R.id.button_mvp6 -> startActivity(Intent(this, Demo6Activity::class.java))
        }
    }
}