package com.caicai.mvpstudyproject.mvp.v2.model

import com.caicai.mvpstudyproject.mvp.v2.basemvp.BaseModel
import com.caicai.mvpstudyproject.mvp.v2.contract.FragmentContract
import okhttp3.Callback
import okhttp3.OkHttpClient

class FragmentModel : BaseModel(), FragmentContract.IFragmentModel {
    override fun requestNetWork(callBack: Callback) {
        OkHttpClient().newCall(okhttp3.Request.Builder().url("https://www.baidu.com").build())
            .enqueue(callBack)
    }
}