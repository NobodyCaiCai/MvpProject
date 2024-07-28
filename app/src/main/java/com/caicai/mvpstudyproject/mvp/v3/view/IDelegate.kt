package com.caicai.mvpstudyproject.mvp.v3.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toolbar

/**
 * View delegate base class
 * 视图层代理的接口协议
 */
interface IDelegate {
    fun onCreate(inflater: LayoutInflater, container: ViewGroup, savedInstanceState: Bundle)

    fun getOptionMenuId(): Int

    fun getToolbar(): Toolbar?

    fun getRootView(): View?

    fun initWidget()
}