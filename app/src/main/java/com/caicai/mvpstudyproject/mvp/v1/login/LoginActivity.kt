package com.caicai.mvpstudyproject.mvp.v1.login

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import com.caicai.mvpstudyproject.R
import com.caicai.mvpstudyproject.mvp.v1.main.MainV1Activity

class LoginActivity: AppCompatActivity(), LoginView {

    private var loginPresenter: LoginPresenter? = null
    private var userName: EditText? = null
    private var password: EditText? = null
    private var progress: ProgressBar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loginPresenter = LoginPresenter(this, LoginModel())
        userName = findViewById(R.id.username)
        password = findViewById(R.id.password)
        progress = findViewById(R.id.progress)

        findViewById<Button>(R.id.button).setOnClickListener{
            loginPresenter?.login(userName?.text.toString(), password?.text.toString())
        }
    }

    override fun showLoading() {
        progress?.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        progress?.visibility = View.GONE
    }

    override fun setUsernameError() {
        userName?.error = getString(R.string.username_error)
    }

    override fun setPasswordError() {
        password?.error = getString(R.string.password_error)
    }

    override fun navigateToHome() {
        startActivity(Intent(this, MainV1Activity::class.java))
    }
}