package com.caicai.mvpstudyproject.mvp.v2

import com.caicai.mvpstudyproject.mvp.v2.basemvp.IBaseActivity
import com.caicai.mvpstudyproject.mvp.v2.basemvp.IBasePresenter
import okhttp3.Callback

// 业务逻辑接口，实现指定的业务逻辑，比如请求网络，处理数据等
interface MainContract {
    // model层接口
    interface IMainModel {
        fun requestNetWork(callback: Callback)
    }

    // view层接口
    interface  IMainView: IBaseActivity {
        fun showDialog()
        fun success(data: String)
    }

    // presenter层接口
    // 这里的泛型是指定view层的接口，是IMainView 而不是 IBaseActivity，这样就可以在presenter层中调用IMainView中的方法
    // 更具体的原因：
    // 1. 类型匹配：IMainPresenter 的职责是与视图进行交互。为了确保 Presenter 能正确操作视图，IMainPresenter 的泛型参数应该是 IMainView，而不是 IBaseActivity。
    // 2. 契约遵守：IMainView 是与 IMainPresenter 相关的视图接口，定义了视图应具备的方法，如 showDialog() 和 success(String content)
    interface  IMainPresenter: IBasePresenter<IMainView> {
        fun handleData()
    }
}