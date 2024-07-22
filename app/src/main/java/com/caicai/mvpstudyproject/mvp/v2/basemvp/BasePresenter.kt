package com.caicai.mvpstudyproject.mvp.v2.basemvp

import android.util.Log
import java.lang.ref.WeakReference
import java.lang.reflect.Proxy

abstract class BasePresenter<V : IBaseActivity> : IBasePresenter<V> {

    private lateinit var mProxyView: V
    private var mWeakReference: WeakReference<IBaseActivity>? = null

    @Suppress("UNCHECKED_CAST")
    override fun attach(view: V) {
        mWeakReference = WeakReference(view)

        val classLoader = view.javaClass.classLoader
        val interfaces = view.javaClass.interfaces
        // 动态代理判断防空
        mProxyView = Proxy.newProxyInstance(classLoader, interfaces) { _, method, args ->
            val currentView = mWeakReference?.get()
            if (currentView != null) {
                method.invoke(currentView, *(args ?: emptyArray()))
            } else {
                null
            }
        } as V
    }

    fun getView(): V {
        return mProxyView
    }

    override fun detach() {
        mWeakReference?.clear()
        mWeakReference = null
    }
}