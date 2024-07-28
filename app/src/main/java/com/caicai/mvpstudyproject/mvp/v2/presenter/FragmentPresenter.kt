package com.caicai.mvpstudyproject.mvp.v2.presenter

import android.util.Log
import com.caicai.mvpstudyproject.mvp.v2.basemvp.BasePresenter
import com.caicai.mvpstudyproject.mvp.v2.contract.FragmentContract
import com.caicai.mvpstudyproject.mvp.v2.model.FragmentModel
import okhttp3.Call
import okhttp3.Callback
import okhttp3.Response
import java.io.IOException

class FragmentPresenter : BasePresenter<FragmentContract.IFragmentView, FragmentModel>(),
    FragmentContract.IFragmentPresenter {

    override fun attach(view: FragmentContract.IFragmentView) {
        super.attach(view)
        Log.i("==========", "FragmentPresenter attach: 绑定view，初始化model")
    }

    override fun handleData() {
        getView().showDialog()
        getModel()?.requestNetWork(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.i("=====", "onFailure: ${e.message}")
            }

            override fun onResponse(call: Call, response: Response) {
                getView().success(response.body?.string() ?: "")
            }
        })
    }
}