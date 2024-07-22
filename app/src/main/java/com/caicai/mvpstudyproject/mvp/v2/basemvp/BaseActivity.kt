package com.caicai.mvpstudyproject.mvp.v2.basemvp

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import com.caicai.mvpstudyproject.mvp.v2.injectInterface.InjectPresenter


/**
 * <P : IBasePresenter> 是一个泛型参数，表示 BaseActivity 类接受一个类型参数 P，且 P 必须是 IBasePresenter 的子类型。
 */

abstract class BaseActivity<V : IBaseActivity, P : IBasePresenter<V>> : IBaseActivity,
    AppCompatActivity() {

    private var mInjectPresenterList: MutableList<BasePresenter<IBaseActivity, BaseModel>>? = mutableListOf()

    protected abstract fun initLayout(savedInstanceState: Bundle?)

    protected abstract fun initViews()

    protected abstract fun initData()

    protected fun <T : View> getView(@IdRes viewId: Int): T {
        return findViewById(viewId)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initLayout(savedInstanceState)
        initPresenter()
        initViews()
        initData()
    }

    /**
     * 依赖注入
     * 通过反射获取当前类的所有属性，判断是否有注解 @InjectPresenter
     * 如果有，则实例化该对象，并调用 attach 方法
     * 通过反射给当前对象的属性赋值
     */
    @Suppress("UNCHECKED_CAST")
    private fun initPresenter() {
        val fields = this::class.java.declaredFields
        for (field in fields) {
            field.getAnnotation(InjectPresenter::class.java) ?: return
            try {
                val type = field.type as Class<out BasePresenter<IBaseActivity, BaseModel>>
                val mInjectPresenter = type.getDeclaredConstructor().newInstance()
                mInjectPresenter.attach(this as IBaseActivity)
                field.isAccessible = true
                // 给当前对象的属性赋值
                field.set(this, mInjectPresenter)
                mInjectPresenterList?.add(mInjectPresenter)
            } catch (e: IllegalAccessException) {
                e.printStackTrace()
            } catch (e: InstantiationException) {
                e.printStackTrace()
            } catch (e: ClassCastException) {
                e.printStackTrace()
                throw RuntimeException("SubClass must extend BasePresenter")
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mInjectPresenterList?.forEach { presenter ->
            presenter.detach()
        }
        mInjectPresenterList?.clear()
    }

    override fun getContext(): Context {
        return this
    }
}