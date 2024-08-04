package com.caicai.mvpstudyproject.mvp.v3.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar

/**
 * View delegate base class
 * View 视图层代理的接口协议
 */
interface IDelegate {
    // 初始化根布局
    fun onCreate(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?)

    fun getRootView(): View?

    fun getOptionMenuId(): Int

    fun getToolbar(): Toolbar?

    // 初始化具体视图（view）
    fun initWidget()
}