package com.caicai.mvpstudyproject.mvp.v3.a_demo.demo4

import com.caicai.mvpstudyproject.mvp.v3.databind.DataBinder

class Demo4DataBinder : DataBinder<FragmentDelegate, Demo4User> {
    override fun viewBindModel(view: FragmentDelegate?, model: Demo4User) {
        if (model.isAvailable()) {
            view?.setTextResult(model.name, model.age)
        }
    }
}