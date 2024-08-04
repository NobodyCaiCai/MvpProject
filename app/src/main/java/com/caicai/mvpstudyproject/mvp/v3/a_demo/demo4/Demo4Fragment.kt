package com.caicai.mvpstudyproject.mvp.v3.a_demo.demo4

import com.caicai.mvpstudyproject.mvp.v3.databind.DataBindFragment
import com.caicai.mvpstudyproject.mvp.v3.databind.DataBinder
import com.caicai.mvpstudyproject.R

class Demo4Fragment : DataBindFragment<FragmentDelegate, Demo4User>() {

    private val user: Demo4User = Demo4User("艾宁w", "5")

    override fun bindEventListener() {
        super.bindEventListener()

        viewDelegate?.setOnClickListener({
            user.name = viewDelegate?.getText(R.id.editText) ?: ""
            user.age = viewDelegate?.getText(R.id.editText2) ?: ""
            notifyModelChange(user)
        }, R.id.fragment_button)
    }

    override fun getDataBinder(): DataBinder<FragmentDelegate, Demo4User> {
        return Demo4DataBinder()
    }

    override fun getViewDelegate(): Class<FragmentDelegate> {
        return FragmentDelegate::class.java
    }
}