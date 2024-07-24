package com.caicai.mvpstudyproject.mvp.v2.contract

import com.caicai.mvpstudyproject.mvp.v2.basemvp.IBaseActivity
import com.caicai.mvpstudyproject.mvp.v2.basemvp.IBasePresenter
import okhttp3.Callback

interface FragmentContract {
    interface IFragmentModel {
        fun requestNetWork(callBack: Callback)
    }

    interface IFragmentView: IBaseActivity {
        fun showDialog()
        fun success(data: String)
    }

    interface IFragmentPresenter: IBasePresenter<IFragmentView> {
        fun handleData()
    }
}