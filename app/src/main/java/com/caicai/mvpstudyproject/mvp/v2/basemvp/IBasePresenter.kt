package com.caicai.mvpstudyproject.mvp.v2.basemvp

interface IBasePresenter<V: IBaseActivity> {
    fun attach(view: V)
    fun detach()
}