package com.caicai.mvpstudyproject.mvp.v3.a_demo.demo4

import android.widget.EditText
import android.widget.TextView
import com.caicai.mvpstudyproject.mvp.v3.view.AppDelegate
import com.caicai.mvpstudyproject.R

class FragmentDelegate : AppDelegate() {
    override fun getRootLayoutId(): Int {
        return R.layout.fragment_user
    }

    override fun initWidget() {
        super.initWidget()
        val editText1 = get<EditText>(R.id.editText)
        val editText2 = get<EditText>(R.id.editText2)
        editText1.hint = "name"
        editText2.hint = "age"
    }

    fun getText(id: Int): String {
        return get<EditText>(id).text.toString()
    }

    fun setTextResult(name: String, age: String) {
        get<TextView>(R.id.text).text = String.format("姓名： %s, 年龄： %s", name, age)
    }
}