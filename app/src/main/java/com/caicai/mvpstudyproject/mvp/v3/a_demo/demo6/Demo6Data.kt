package com.caicai.mvpstudyproject.mvp.v3.a_demo.demo6

import com.caicai.mvpstudyproject.mvp.v3.model.IModel
import de.greenrobot.event.EventBus


class Demo6Data(name: String) : IModel {
    var name: String = name
        set(value) {
            field = value
            EventBus.getDefault().post(this)
        }
}