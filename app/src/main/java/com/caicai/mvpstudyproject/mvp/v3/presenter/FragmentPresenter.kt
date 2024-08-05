package com.caicai.mvpstudyproject.mvp.v3.presenter

import android.os.Bundle
import android.view.ContextMenu
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import com.caicai.mvpstudyproject.mvp.v3.view.IDelegate


/**
 * Presenter base class for Fragment
 * Presenter层的实现基类
 *
 * @param <T> View delegate class type
 */
abstract class FragmentPresenter<T: IDelegate>: Fragment() {

    protected var viewDelegate: T? = null

    private fun initViewDelegate(): T? {
        try {
            return getViewDelegate().getDeclaredConstructor().newInstance()
        } catch (t: Throwable) {
            throw RuntimeException("class to IDelegate fail")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewDelegate = initViewDelegate()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        viewDelegate?.onCreate(inflater, container, savedInstanceState)
        return viewDelegate?.getRootView()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewDelegate?.initWidget()
        bindEventListener()
        initMenu(requireActivity())
    }

    private fun initMenu(menuHost: MenuHost) {
        menuHost.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                viewDelegate?.getOptionMenuId()?.let {
                    menuInflater.inflate(it, menu)
                }
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                Toast.makeText(context, menuItem.itemId, Toast.LENGTH_LONG)
                return true
            }
        })
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        if (viewDelegate == null) {
            viewDelegate = initViewDelegate()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        viewDelegate = null
    }

    // 可以被重写
    protected open fun bindEventListener() {}

    // 必须被重写
    protected abstract fun getViewDelegate(): Class<T>
}