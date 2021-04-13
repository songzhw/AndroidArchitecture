package ca.six.demo.cleanviper.biz.session

import androidx.lifecycle.LifecycleObserver

object SessionDepStore {
    var loginPresenter: LoginPresenter? = null
        get() = LoginPresenter()
        set(value) {
            field = value
        }
}

interface SessionDepInjected {
    val sessionLifecycle: SessionDepLifecycle
        get() = SessionDepLifecycle()

    var loginPresenter: LoginPresenter
        get() = sessionLifecycle.loginPresenter
        set(value) { field = value}

}

class SessionDepLifecycle : LifecycleObserver {
    val loginPresenter = SessionDepStore.loginPresenter
}

/*
[选用get()的思路]
1. get(): 会每次调用都new一个. 这个可能会出问题, 需要使用时小心
        -- 类似Swift中的 Computed Property
        -- 但kotlin中一定要有个初始值, 我只好给了一个null
2. lazy prop只能用于val, 不利于我注入mock object
3. 由一个方法返回presenter是可以. 但同样要mock一个 object(单例)的方法, 有困难 (我又不想用PowerMock)
 */