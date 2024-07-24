package com.caicai.mvpstudyproject.mvp.v2.proxy

import android.util.Log
import com.caicai.mvpstudyproject.mvp.v2.basemvp.BaseModel
import com.caicai.mvpstudyproject.mvp.v2.basemvp.BasePresenter
import com.caicai.mvpstudyproject.mvp.v2.basemvp.IBaseActivity
import com.caicai.mvpstudyproject.mvp.v2.inject.InjectPresenter


open class ProxyImpl(view: IBaseActivity) : IProxy {

    private var mView: IBaseActivity = view
    private var mInjectPresenter: MutableList<BasePresenter<IBaseActivity, BaseModel>>? = mutableListOf()

    @Suppress("UNCHECKED_CAST")
    override fun bindPresenter() {
        val fields = mView.javaClass.declaredFields
        for (field in fields) {
            val annotation = field.getAnnotation(InjectPresenter::class.java)
            annotation?.let {
                try{
                    val clazz = (field.type) as Class<out BasePresenter<IBaseActivity, BaseModel>>
                    val mPresenter = clazz.getDeclaredConstructor().newInstance()
                    mPresenter.attach(mView)
                    field.isAccessible = true
                    field.set(mView, mPresenter)
                    mInjectPresenter?.add(mPresenter)
                } catch (e: Throwable) {
                    Log.i("=====", "error: ${e.message}")
                }
            }
        }
    }

    override fun unbindPresenter() {
        mInjectPresenter?.forEach {
            it.detach()
        }
        mInjectPresenter?.clear()
        mInjectPresenter = null
    }
}