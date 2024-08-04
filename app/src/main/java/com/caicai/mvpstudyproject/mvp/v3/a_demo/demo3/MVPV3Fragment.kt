package com.caicai.mvpstudyproject.mvp.v3.a_demo.demo3

import android.view.View
import com.caicai.mvpstudyproject.mvp.v3.a_demo.demo1.SimpleDelegate
import com.caicai.mvpstudyproject.mvp.v3.presenter.FragmentPresenter
import com.caicai.mvpstudyproject.R

class MVPV3Fragment: FragmentPresenter<SimpleDelegate>(), View.OnClickListener {

    override fun getViewDelegate(): Class<SimpleDelegate> {
        return SimpleDelegate::class.java
    }

    override fun bindEventListener() {
        super.bindEventListener()
        viewDelegate?.setOnClickListener(this, R.id.button_simple_v1)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.button_simple_v1 -> viewDelegate?.setText("你点击了button")
        }
    }
}