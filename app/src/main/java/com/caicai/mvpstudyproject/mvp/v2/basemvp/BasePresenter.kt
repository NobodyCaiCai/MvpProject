package com.caicai.mvpstudyproject.mvp.v2.basemvp

import android.util.Log
import java.lang.ref.SoftReference
import java.lang.ref.WeakReference
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Proxy

abstract class BasePresenter<V : IBaseActivity, M : BaseModel> : IBasePresenter<V> {

    private var mModel: M? = null
    private lateinit var mProxyView: V

    @Suppress("UNCHECKED_CAST")
    override fun attach(view: V) {
        val mWeakReference: WeakReference<IBaseActivity> = WeakReference(view)
        val classLoader = view.javaClass.classLoader
        val interfaces = view.javaClass.interfaces

        /*
          *  通过动态代理，解决View判空问题
          *  每次mProxyView调用方法的时候，都会调用invoke方法
          *  首先会判断当前的view是否为空，如果为空，则mProxyView调用方法整体返回null
          *  否则，调用被代理对象的方法;
          *  这里，mProxyView不会被赋予null，mProxyView是一个代理对象，代理对象的invoke方法会判断当前的view是否为空
          */
        mProxyView = Proxy.newProxyInstance(classLoader, interfaces) { _, method, args ->
            val currentView = mWeakReference.get()
            if (currentView != null) {
                method.invoke(currentView, *(args ?: emptyArray()))
            } else {
                null // 如果view为空，不调用方法，调用方调用方法直接放返回null
            }
        } as V

        /**
         *  通过泛型 + 反射获取model数据
         *  1. 获取当前类的泛型超类
         *      type返回的类型：全限定类名 + 泛型参数
         *      BasePresenter <MainContract$IMainView， DataModel>
         *  2. 获取泛型参数
         *  3. 通过反射创建model对象
         */
        val type = this.javaClass.genericSuperclass
        if (type != null) {
            val arguments = (type as? ParameterizedType)?.actualTypeArguments
            val clazz = arguments?.get(1) as? Class<M>
            try {
                mModel = clazz?.getDeclaredConstructor()?.newInstance()
            } catch (e: IllegalAccessException) {
                Log.i(TAG, "attach: IllegalAccessException, e: $e")
            } catch (e: InstantiationException) {
                Log.i(TAG, "attach: InstantiationException, e: $e")
            }
        }
    }

    fun getView(): V {
        return mProxyView
    }

    fun getModel(): M? {
        return mModel
    }

    override fun detach() {
        mModel = null
    }

    companion object {
        private val TAG = this::class.java.simpleName
    }
}