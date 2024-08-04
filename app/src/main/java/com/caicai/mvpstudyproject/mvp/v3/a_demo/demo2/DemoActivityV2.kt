package com.caicai.mvpstudyproject.mvp.v3.a_demo.demo2

import android.widget.Button
import com.caicai.mvpstudyproject.mvp.v3.a_demo.demo1.SimpleDelegate
import com.caicai.mvpstudyproject.mvp.v3.databind.DataBindActivity
import com.caicai.mvpstudyproject.mvp.v3.databind.DataBinder
import com.caicai.mvpstudyproject.R

class DemoActivityV2 : DataBindActivity<SimpleDelegate, DemoBean>() {

    private var mDemoBean = DemoBean("test")

    override fun bindEvenListener() {
        super.bindEvenListener()
        viewDelegate?.get<Button>(R.id.button_simple_v1)?.setOnClickListener {
            mDemoBean.name = "点击了button"
            notifyModelChanged(mDemoBean)
        }
    }


    override fun getDataBinder(): DataBinder<SimpleDelegate, DemoBean> {
        return Demo2DataBinder()
    }

    override fun getDelegateClass(): Class<SimpleDelegate> {
        return SimpleDelegate::class.java
    }
}