package com.caicai.mvpstudyproject.mvp.v3.presenter

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import com.caicai.mvpstudyproject.mvp.v3.view.IDelegate

/**
 * Presenter base class for Activity
 * Presenter层的实现基类
 * TheMVP中，presenter层是通过Activity Fragment实现的
 * 泛型解决 直接引用具体对象的问题
 */

abstract class ActivityPresenter<T: IDelegate> : AppCompatActivity() {

    protected var viewDelegate: T? = null

    init {
        viewDelegate = initViewDelegate()
    }

    private fun initViewDelegate(): T? {
        try {
            return getDelegateClass().getDeclaredConstructor().newInstance()
        } catch (e: InstantiationException) {
            throw RuntimeException("create IDelegate error", e)
        } catch (e: IllegalAccessException) {
            throw RuntimeException("create IDelegate error", e)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewDelegate?.onCreate(layoutInflater, null, savedInstanceState)
        setContentView(viewDelegate?.getRootView())
        initToolBar()
        viewDelegate?.initWidget()
        bindEvenListener()
    }

    private fun initToolBar() {
        val toolbar = viewDelegate?.getToolbar()
        toolbar?.let {
            setSupportActionBar(it)
        }
    }

    // activity和fragment作为presenter会有一个BUG就是当回收时, viewDelegate被回收
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        try {
            viewDelegate = getDelegateClass()?.getDeclaredConstructor()?.newInstance()
        } catch (e: Throwable) {
            throw RuntimeException("create viewDelegate error： ${e.message}")
        }
    }

    // onCreateOptionsMenu：只会在第一次初始化菜单时调用一次，之后不会再调用
    // onPrepareOptionsMenu ：在onCreateOptionsMenu执行后，菜单被显示前调用；如果菜单已经被创建，则在菜单显示前被调用，会被调用多次
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val optionMenuId = viewDelegate?.getOptionMenuId()
        optionMenuId?.let {
            menuInflater.inflate(optionMenuId, menu)
            return true
        }
        return super.onCreateOptionsMenu(menu)
    }

    override fun onDestroy() {
        super.onDestroy()
        viewDelegate = null
    }

    protected open fun bindEvenListener() {}

    protected abstract fun getDelegateClass(): Class<T>
}