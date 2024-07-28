package com.caicai.mvpstudyproject.mvp.v3.view

import android.os.Bundle
import android.util.SparseArray
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toolbar
import androidx.annotation.IdRes

abstract class AppDelegate: IDelegate {

    protected val mViews: SparseArray<View> = SparseArray()

    private var rootView: View? = null

    @IdRes
    abstract fun getRootLayoutId(): Int


    override fun onCreate(
        inflater: LayoutInflater,
        container: ViewGroup,
        savedInstanceState: Bundle
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

    override fun initWidget() {
        TODO("Not yet implemented")
    }

    fun setRootView(view: View) {
        rootView = view
    }



}