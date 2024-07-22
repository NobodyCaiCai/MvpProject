package com.caicai.mvpstudyproject.mvp.v2.model

import com.caicai.mvpstudyproject.mvp.v2.MainContract
import com.caicai.mvpstudyproject.mvp.v2.basemvp.BaseModel
import okhttp3.Callback
import okhttp3.OkHttpClient

class DataModel: BaseModel(), MainContract.IMainModel{
    override fun requestNetWork(callback: Callback) {
        val okHttpClient = OkHttpClient()
        val request = okhttp3.Request.Builder()
            .url("https://www.baidu.com")
            .build()
        okHttpClient.newCall(request).enqueue(callback)
    }
}