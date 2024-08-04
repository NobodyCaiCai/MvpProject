package com.caicai.mvpstudyproject.mvp.v3.databind

import android.os.Bundle
import android.view.View
import com.caicai.mvpstudyproject.mvp.v3.model.IModel
import com.caicai.mvpstudyproject.mvp.v3.presenter.FragmentPresenter
import com.caicai.mvpstudyproject.mvp.v3.view.IDelegate

abstract class DataBindFragment<T : IDelegate, M : IModel> : FragmentPresenter<T>() {

    private var mDataBinder: DataBinder<T, M>? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mDataBinder = getDataBinder()
    }

    protected abstract fun getDataBinder(): DataBinder<T, M>

    fun notifyModelChange(data: M) {
        mDataBinder?.viewBindModel(viewDelegate, data)
    }
}