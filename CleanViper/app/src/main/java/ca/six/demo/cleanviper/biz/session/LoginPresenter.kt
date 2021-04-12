package ca.six.demo.cleanviper.biz.session

import ca.six.demo.cleanviper.core.di.HttpInjected
import ca.six.demo.cleanviper.ext.clearedBy
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class LoginPresenter : HttpInjected {
    lateinit var disposables : CompositeDisposable

    fun login(name: String, password: String) {
        //TODO password -> sha128

        // 这里是个模拟后台的过程, 根据name来决定login是否成功
        val httpReqeust = if (name == "szw") http.loginVIPUser()
        else http.LoginUser()


        if (name == "") {
            http.loginAndFail()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { resp -> println("szw resp = ${resp.code()}") }
                .clearedBy(disposables)
        } else {
            httpReqeust
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { session -> println("szw $session") }
                .clearedBy(disposables)
        }
    }
}

/*
1. 这里我并没有采用Interactor. 因为感觉这里逻辑较简单, 用了interactor, 那presenter基本就是个空壳子, 来回传递而已.
    => 所以我个人觉得, 设计并不是一成不变的, 得因地制宜

 */