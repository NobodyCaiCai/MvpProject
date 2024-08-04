package com.caicai.mvpstudyproject.mvp.v3.databind

import android.os.Bundle
import com.caicai.mvpstudyproject.mvp.v3.model.IModel
import com.caicai.mvpstudyproject.mvp.v3.presenter.ActivityPresenter
import com.caicai.mvpstudyproject.mvp.v3.view.IDelegate

// ActivityPresenter<T> 其中T不要写具体的
abstract class DataBindActivity<T: IDelegate, M: IModel>: ActivityPresenter<T>() {

    private var mDataBinder: DataBinder<T, M>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mDataBinder = getDataBinder()
    }

    abstract fun getDataBinder(): DataBinder<T, M>

    fun notifyModelChanged(data: M){
        mDataBinder?.viewBindModel(viewDelegate, data)
    }
}