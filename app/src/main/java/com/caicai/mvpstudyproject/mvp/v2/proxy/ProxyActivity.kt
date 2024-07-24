package com.caicai.mvpstudyproject.mvp.v2.proxy

import com.caicai.mvpstudyproject.mvp.v2.basemvp.IBaseActivity

class ProxyActivity<V: IBaseActivity>(view: V): ProxyImpl(view = view)