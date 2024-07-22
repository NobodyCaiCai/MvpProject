package com.caicai.mvpstudyproject.mvp.v2.presenter

import android.util.Log
import com.caicai.mvpstudyproject.mvp.v2.MainContract
import com.caicai.mvpstudyproject.mvp.v2.basemvp.BasePresenter
import com.caicai.mvpstudyproject.mvp.v2.model.DataModel
import okhttp3.Call
import okhttp3.Callback
import okhttp3.Response
import java.io.IOException

class MainPresenter : BasePresenter<MainContract.IMainView>(), MainContract.IMainPresenter {

    private var mModel: MainContract.IMainModel? = null

    init {
        mModel = DataModel()
    }

    override fun attach(view: MainContract.IMainView) {
        super.attach(view)
        mModel = DataModel()
    }

    override fun handleData() {
        val view = getView()
        mModel?.requestNetWork(object: Callback{
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
        mModel = null
        Log.i("==========", "detech: 解除绑定，释放内存");
    }
}