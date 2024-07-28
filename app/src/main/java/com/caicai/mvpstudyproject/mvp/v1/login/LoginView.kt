package com.caicai.mvpstudyproject.mvp.v1.login

interface LoginView {
    fun showLoading()

    fun hideLoading()

    fun setUsernameError()

    fun setPasswordError()

    fun navigateToHome()
}