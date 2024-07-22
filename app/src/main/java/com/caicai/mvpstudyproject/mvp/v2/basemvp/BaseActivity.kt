package com.caicai.mvpstudyproject.mvp.v2.basemvp

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity

/**
 * <P : IBasePresenter> 是一个泛型参数，表示 BaseActivity 类接受一个类型参数 P，且 P 必须是 IBasePresenter 的子类型。
 */

abstract class BaseActivity<V : IBaseActivity, P : IBasePresenter<V>> : IBaseActivity,
    AppCompatActivity() {

    protected var mPresenter: P? = null

    protected abstract fun initLayout(savedInstanceState: Bundle?)

    protected abstract fun setPresenter(): P

    protected abstract fun initViews()

    protected abstract fun initData()

    protected fun <T : View> getView(@IdRes viewId: Int): T {
        return findViewById(viewId)
    }

    @Suppress("UNCHECKED_CAST")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initLayout(savedInstanceState)
        mPresenter = setPresenter()
        mPresenter?.attach(this as V)
        initViews()
        initData()
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter?.detach()
        mPresenter = null
    }

    override fun getContext(): Context {
        return this
    }
}