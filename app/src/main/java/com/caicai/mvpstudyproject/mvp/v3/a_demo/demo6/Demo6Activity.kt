package com.caicai.mvpstudyproject.mvp.v3.a_demo.demo6

import android.os.Bundle
import com.caicai.mvpstudyproject.R
import com.caicai.mvpstudyproject.mvp.v3.a_demo.demo1.SimpleDelegate
import com.caicai.mvpstudyproject.mvp.v3.presenter.ActivityPresenter
import de.greenrobot.event.EventBus

class Demo6Activity : ActivityPresenter<SimpleDelegate>() {
    override fun getDelegateClass(): Class<SimpleDelegate> {
        return SimpleDelegate::class.java
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        EventBus.getDefault().register(this)
    }

    override fun bindEvenListener() {
        super.bindEvenListener()
        viewDelegate?.setOnClickListener({
            val data = Demo6Data("爱宁w")
            data.name = "峰哥"
        }, R.id.button_simple_v1)
    }

    override fun onDestroy() {
        super.onDestroy()
        EventBus.getDefault().unregister(this)
    }

    fun onEventMainThread(data: Demo6Data) {
        viewDelegate!!.setText(data.name)
    }
}