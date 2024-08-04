package com.caicai.mvpstudyproject.mvp.v3.a_demo.demo1

import android.widget.TextView
import com.caicai.mvpstudyproject.mvp.v3.view.AppDelegate
import com.caicai.mvpstudyproject.R

class SimpleDelegate: AppDelegate() {
    override fun getRootLayoutId(): Int {
        return R.layout.delegate_simple
    }

    override fun initWidget() {
        super.initWidget()
        setText("在视图代理层创建布局")
    }

    fun setText(msg: String) {
        val view = get<TextView>(R.id.text_simple_v1)
        view.text = msg
    }
}