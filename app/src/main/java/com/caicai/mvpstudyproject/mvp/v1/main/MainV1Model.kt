package com.caicai.mvpstudyproject.mvp.v1.main

import android.os.Handler
import android.os.Looper

class MainV1Model {

    fun findItems(callback: (List<String>) -> Unit) {
        Handler(Looper.getMainLooper()).postDelayed({ callback(createArrayList()) }, 2000)
    }

    private fun createArrayList(): List<String> {
        return (1 .. 10).map { "item: $it" }
    }
}