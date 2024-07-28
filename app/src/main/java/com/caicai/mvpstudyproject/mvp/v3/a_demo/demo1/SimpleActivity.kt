package com.caicai.mvpstudyproject.mvp.v3.a_demo.demo1

import android.view.View
import com.caicai.mvpstudyproject.mvp.v3.presenter.ActivityPresenter
import com.caicai.mvpstudyproject.R

class SimpleActivity: ActivityPresenter<SimpleDelegate>(), View.OnClickListener {

    override fun bindEvenListener() {
        super.bindEvenListener()
        viewDelegate?.setOnClickListener(this, R.id.button_simple_v1)
    }

    override fun getDelegateClass(): Class<SimpleDelegate> {
        return SimpleDelegate::class.java
    }

    override fun onClick(v: View?) {
        val id = v?.id
        when (id) {
            R.id.button_simple_v1 -> viewDelegate?.toast("点击了button_simple_v1")
        }
    }
}