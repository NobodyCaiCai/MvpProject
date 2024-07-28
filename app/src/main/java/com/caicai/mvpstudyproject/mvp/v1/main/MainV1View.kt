package com.caicai.mvpstudyproject.mvp.v1.main

interface MainV1View {

    fun showProgress()

    fun hideProgress()

    fun setItems(items: List<String>)

    fun showMessage(message: String)
}