package com.caicai.mvpstudyproject.mvp.v1.login

class LoginPresenter(private val loginView: LoginView?, private val loginModel: LoginModel?): LoginModel.OnLoginFinishedListener {

    fun login(username: String?, password: String?) {
        loginView?.showLoading()
        loginModel?.login(username, password,this)
    }

    override fun onSuccess() {
        loginView?.hideLoading()
        loginView?.navigateToHome()
    }

    override fun onUsernameError() {
        loginView?.let {
            it.setUsernameError()
            it.hideLoading()
        }
    }

    override fun onPasswordError() {
        loginView?.let {
            it.setPasswordError()
            it.hideLoading()
        }
    }
}