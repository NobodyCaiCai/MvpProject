package com.caicai.mvpstudyproject.mvp.v3.a_demo.demo5

import androidx.appcompat.widget.Toolbar
import com.caicai.mvpstudyproject.mvp.v3.view.AppDelegate
import com.caicai.mvpstudyproject.R

class Demo5Delegate : AppDelegate() {
    override fun getRootLayoutId(): Int {
        return R.layout.activity_toolbar
    }

    override fun getOptionMenuId(): Int {
        return R.menu.menu
    }

    override fun getToolbar(): Toolbar {
        return get(R.id.toolbar)
    }


}