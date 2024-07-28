package com.caicai.mvpstudyproject.mvp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.caicai.mvpstudyproject.R
import com.caicai.mvpstudyproject.mvp.v1.login.LoginActivity
import com.caicai.mvpstudyproject.mvp.v2.view.FirstActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.button1).setOnClickListener(this)
        findViewById<Button>(R.id.button2).setOnClickListener(this)
        findViewById<Button>(R.id.button3).setOnClickListener(this)
        findViewById<Button>(R.id.button4).setOnClickListener(this)
        findViewById<Button>(R.id.button5).setOnClickListener(this)
        findViewById<Button>(R.id.button6).setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.button1 -> {
                // https://github.com/antoniolg/androidmvp： 最基本的MVP架构
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
            }

            R.id.button2 -> {
                //  https://blog.csdn.net/smile_Running/article/details/94724540：MVP升级版
                val intent = Intent(this, FirstActivity::class.java)
                startActivity(intent)
            }
        }
    }
}