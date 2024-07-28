package com.caicai.mvpstudyproject.mvp.v3.view

import android.app.Activity
import android.os.Bundle
import android.util.SparseArray
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.IdRes
import androidx.appcompat.widget.Toolbar

abstract class AppDelegate : IDelegate {

    private val mViews: SparseArray<View> = SparseArray()

    private var rootView: View? = null

    @IdRes
    abstract fun getRootLayoutId(): Int

    override fun onCreate(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ) {
        val rootLayoutId = getRootLayoutId()
        rootView = inflater.inflate(rootLayoutId, container, false)
    }

    override fun getOptionMenuId(): Int {
        return 0
    }

    override fun getToolbar(): Toolbar? {
        return null
    }

    override fun getRootView(): View? {
        return rootView
    }

    override fun initWidget() {}

    fun setRootView(view: View) {
        rootView = view
    }

    @Suppress("UNCHECKED_CAST")
    private fun <T: View> bindView(@IdRes id: Int): T {
        var view = mViews[id] as? T
        if (view == null) {
            view = rootView?.findViewById(id) as? T
            if (view != null) {
                mViews.put(id, view)
            } else {
                throw IllegalArgumentException("can't cast to expected type")
            }
        }

        return view
    }

    // bindView的第二种写法，这种写法可能会throw异常（ as T）
    @Suppress("UNCHECKED_CAST")
    private fun <T: View> bindView2(@IdRes id: Int): T {
        return mViews[id] as? T ?: (rootView?.findViewById(id) as? T).also {
            mViews[id] = it
        } as T
    }

    fun <T: View> get(@IdRes id: Int) : T {
        return bindView(id)
    }

    // vararg可变数量的参数标记
    fun setOnClickListener(listener: View.OnClickListener, vararg ids: Int) {
        ids.forEach { id ->
            get<View>(id).setOnClickListener(listener)
        }
    }

    fun toast(msg: CharSequence) {
        Toast.makeText(rootView?.context, msg, Toast.LENGTH_SHORT).show()
    }

    @Suppress("UNCHECKED_CAST")
    fun <T: Activity> getActivity(): T? {
        return rootView?.context as? T
    }
}