package com.caicai.mvpstudyproject.mvp.v1.main

import okhttp3.Callback

class MainV1Presenter(private val mainV1View: MainV1View?, private val model: MainV1Model?) {

    fun initData() {
        mainV1View?.showProgress()
        model?.findItems(this::setItems)
    }

    private fun setItems(items: List<String>) {
        mainV1View?.hideProgress()
        mainV1View?.setItems(items)
    }

    fun onItemClick(item: String) {
        mainV1View?.showMessage(item)
    }
}