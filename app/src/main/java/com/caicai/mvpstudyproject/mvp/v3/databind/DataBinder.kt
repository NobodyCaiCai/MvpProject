package com.caicai.mvpstudyproject.mvp.v3.databind

import com.caicai.mvpstudyproject.mvp.v3.model.IModel
import com.caicai.mvpstudyproject.mvp.v3.view.IDelegate

// viewModel简单实现,实现视图（view）和数据（model）的双向绑定

interface DataBinder<T: IDelegate, M: IModel> {

    // 将数据和view绑定， 等数据变化的时候，自动更改ui（数据改变，回调本方法）
    fun viewBindModel(view: T?, model: M)
}