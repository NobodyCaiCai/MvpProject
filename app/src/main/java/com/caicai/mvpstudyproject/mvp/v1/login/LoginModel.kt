package com.caicai.mvpstudyproject.mvp.v1.login

import android.os.Handler
import android.os.Looper


class LoginModel {

    // 回调函数，用于通知登录结果，这是需要UI展示的一些表现，所以需要UI操作
    // Model层无法直接操作View，所以需要Presenter层实现，通过P层实现调用View的操作
    interface OnLoginFinishedListener {
        fun onSuccess()

        fun onUsernameError()

        fun onPasswordError()
    }

    fun login(userName: String?, password: String?, listener: OnLoginFinishedListener) {
        // mock login, 延迟2秒
        Handler(Looper.getMainLooper()).postDelayed({
            if (userName.isNullOrBlank()) {
                listener.onUsernameError()
                return@postDelayed
            }
            if (password.isNullOrBlank()) {
                listener.onPasswordError()
                return@postDelayed
            }
            listener.onSuccess()
        }, 2000)
    }
}