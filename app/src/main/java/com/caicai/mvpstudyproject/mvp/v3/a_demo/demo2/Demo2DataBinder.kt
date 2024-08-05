package com.caicai.mvpstudyproject.mvp.v3.a_demo.demo2

import com.caicai.mvpstudyproject.mvp.v3.a_demo.demo1.SimpleDelegate
import com.caicai.mvpstudyproject.mvp.v3.databind.DataBinder

class Demo2DataBinder : DataBinder<SimpleDelegate, DemoBean> {
    override fun viewBindModel(view: SimpleDelegate?, model: DemoBean) {
        view?.setText(model.name)
    }
}