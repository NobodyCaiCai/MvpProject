package com.caicai.mvpstudyproject.mvp.v3.a_demo.demo5

import android.view.MenuItem
import android.widget.Toast
import com.caicai.mvpstudyproject.mvp.v3.presenter.ActivityPresenter
import com.caicai.mvpstudyproject.R


class Demo5Activity : ActivityPresenter<Demo5Delegate>() {
    override fun getDelegateClass(): Class<Demo5Delegate> {
        return Demo5Delegate::class.java
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        if (item.itemId == R.id.menu2) {
//            Toast.makeText(this, "lllllllllllll", Toast.LENGTH_LONG)
//        }
        return super.onOptionsItemSelected(item)
    }

}