package com.caicai.mvpstudyproject.mvp.v2.basemvp

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.IdRes
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import com.caicai.mvpstudyproject.mvp.v2.inject.InjectPresenter
import com.caicai.mvpstudyproject.mvp.v2.proxy.ProxyActivity
import com.caicai.mvpstudyproject.mvp.v2.proxy.ProxyFragment

abstract class BaseFragment : IBaseActivity, Fragment() {

    private var mProxyFragment: ProxyFragment<IBaseActivity>? = null
    private var mInjectPresenter: MutableList<BasePresenter<IBaseActivity, BaseModel>>? = mutableListOf()

    @LayoutRes
    protected abstract fun setLayout(): Int

    protected abstract fun initViews(saveInstanceState: Bundle?)

    protected abstract fun initData()

    protected fun  <T : View> getView(@IdRes viewId: Int): T {
        return requireView().findViewById(viewId)
    }

//    @Suppress("UNCHECKED_CAST")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(setLayout(), container, false)
        mProxyFragment = createProxyFragment()
        mProxyFragment?.bindPresenter()
//        val fields = this.javaClass.declaredFields
//        for (field in fields) {
//            val annotation = field.getAnnotation(InjectPresenter::class.java)
//            annotation?.let {
//                try{
//                    val clazz = (field.type) as Class<out BasePresenter<IBaseActivity, BaseModel>>
//                    val mPresenter = clazz.getDeclaredConstructor().newInstance()
//                    mPresenter.attach(this)
//                    field.isAccessible = true
//                    field.set(this, mPresenter)
//                    mInjectPresenter?.add(mPresenter)
//                } catch (e: Throwable) {
//                    Log.i("=====", "error: ${e.message}")
//                }
//            }
//        }
        return view
    }

    private fun createProxyFragment(): ProxyFragment<IBaseActivity>? {
        if (mProxyFragment == null) {
            return ProxyFragment(this)
        }
        return mProxyFragment
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews(savedInstanceState)
        initData()
    }

    override fun onDestroy() {
        super.onDestroy()
//        mInjectPresenter?.forEach {
//            it.detach()
//        }
//        mInjectPresenter?.clear()
//        mInjectPresenter = null
        mProxyFragment?.unbindPresenter()
    }
}