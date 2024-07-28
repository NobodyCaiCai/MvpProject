package com.caicai.mvpstudyproject.mvp.v1.main

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.caicai.mvpstudyproject.R

class MainV1Activity: AppCompatActivity(), MainV1View {

    private var progress: ProgressBar? = null
    private var recycleView: RecyclerView? = null
    private var mainV1Presenter: MainV1Presenter = MainV1Presenter(this, MainV1Model())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_v1_main)
        progress = findViewById(R.id.progress_v1)
        recycleView = findViewById(R.id.list_v1)
        mainV1Presenter.initData()
    }

    override fun showProgress() {
        progress?.visibility = View.VISIBLE
        recycleView?.visibility = View.INVISIBLE
    }

    override fun hideProgress() {
        progress?.visibility = View.INVISIBLE
        recycleView?.visibility = View.VISIBLE
    }

    override fun setItems(items: List<String>) {
        recycleView?.adapter = MainV1Adapter(items, mainV1Presenter::onItemClick)
    }

    override fun showMessage(message: String) {
        Toast.makeText(this, "test", Toast.LENGTH_LONG).show()
    }
}