package com.caicai.mvpstudyproject.mvp.v2.basemvp

abstract class BasePresenter<V : IBaseActivity> : IBasePresenter<V> {

    var mView: V? = null

    override fun attach(view: V) {
        mView = view
    }

    override fun detach() {
        mView = null
    }
}