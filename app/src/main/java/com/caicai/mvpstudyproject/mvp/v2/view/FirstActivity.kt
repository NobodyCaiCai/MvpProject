package com.caicai.mvpstudyproject.mvp.v2.view

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.TextView
import android.widget.Toast
import com.caicai.mvpstudyproject.R
import com.caicai.mvpstudyproject.mvp.v2.contract.MainContract
import com.caicai.mvpstudyproject.mvp.v2.basemvp.BaseActivity
import com.caicai.mvpstudyproject.mvp.v2.inject.InjectPresenter
import com.caicai.mvpstudyproject.mvp.v2.presenter.MainPresenter

class FirstActivity : BaseActivity<MainContract.IMainView, MainContract.IMainPresenter>(),
    MainContract.IMainView {

    @InjectPresenter
    private var mPresenter: MainPresenter? = null
    private var mTextView: TextView? = null

    override fun initLayout(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_first)
    }

    override fun initViews() {
        mTextView = getView(R.id.text_v1)
        mTextView?.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
    }

    override fun initData() {
//        mPresenter?.handleData()
    }

    override fun showDialog() {
        val progressDialog = ProgressDialog(getContext())
        progressDialog.show()

        Handler(Looper.getMainLooper()).postDelayed({
            progressDialog.dismiss()
        }, 2000)
    }

    override fun success(data: String) {
        runOnUiThread {
            Toast.makeText(this, data, Toast.LENGTH_SHORT).show()
            mTextView?.text = data
        }
    }
}