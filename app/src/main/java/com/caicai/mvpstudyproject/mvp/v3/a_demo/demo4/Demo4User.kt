package com.caicai.mvpstudyproject.mvp.v3.a_demo.demo4

import com.caicai.mvpstudyproject.mvp.v3.model.IModel

data class Demo4User(var name: String, var age: String) : IModel {
    fun isAvailable(): Boolean = name.isNotBlank() && age.isNotBlank()
}