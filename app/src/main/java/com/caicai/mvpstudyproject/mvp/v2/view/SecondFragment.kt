package com.caicai.mvpstudyproject.mvp.v2.view

import android.app.ProgressDialog
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.TextView
import android.widget.Toast
import com.caicai.mvpstudyproject.R
import com.caicai.mvpstudyproject.mvp.v2.basemvp.BaseFragment
import com.caicai.mvpstudyproject.mvp.v2.contract.FragmentContract
import com.caicai.mvpstudyproject.mvp.v2.inject.InjectPresenter
import com.caicai.mvpstudyproject.mvp.v2.presenter.FragmentPresenter

class SecondFragment: BaseFragment(), FragmentContract.IFragmentView {

    private var mTextView: TextView? = null

    @InjectPresenter
    private var mPresenter: FragmentPresenter? = null

    override fun setLayout(): Int {
        return R.layout.fragment_second
    }

    override fun initViews(saveInstanceState: Bundle?) {
        mTextView = getView(R.id.fragment_textview)
    }

    override fun initData() {
        mPresenter?.handleData()
    }

    override fun showDialog() {
        val progressDialog = ProgressDialog(context)
        progressDialog.show()

        Handler(Looper.getMainLooper()).postDelayed({
            progressDialog.dismiss()
        }, 2000)
    }

    override fun success(data: String) {
        activity?.runOnUiThread {
            mTextView?.text = data
            Toast.makeText(context, data, Toast.LENGTH_LONG).show()
        }
    }
}