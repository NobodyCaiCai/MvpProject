package com.caicai.mvpstudyproject.mvp.v2.presenter

import android.util.Log
import com.caicai.mvpstudyproject.mvp.v2.MainContract
import com.caicai.mvpstudyproject.mvp.v2.basemvp.BasePresenter
import com.caicai.mvpstudyproject.mvp.v2.model.DataModel
import okhttp3.Call
import okhttp3.Callback
import okhttp3.Response
import java.io.IOException

class MainPresenter : BasePresenter<MainContract.IMainView, DataModel>(), MainContract.IMainPresenter {

    override fun attach(view: MainContract.IMainView) {
        super.attach(view)
        Log.i("==========", "attach: 绑定view，初始化model");
    }

    override fun handleData() {
        val view = getView()
        getModel()?.requestNetWork(object: Callback{
            override fun onFailure(call: Call, e: IOException) {

            }
            /**
             * 发起请求，获得回调数据
             */
            override fun onResponse(call: Call, response: Response) {
                response.body?.string()?.let {
                    view.success(it.substring(0, 1000))
                }
            }
        })
    }

    override fun detach() {
        super.detach()
        Log.i("==========", "detach: 解除绑定，释放内存");
    }
}