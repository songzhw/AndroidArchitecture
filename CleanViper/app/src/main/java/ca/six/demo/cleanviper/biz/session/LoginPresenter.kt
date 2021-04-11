package ca.six.demo.cleanviper.biz.session

import ca.six.demo.cleanviper.core.di.HttpInjected
import ca.six.demo.cleanviper.ext.clearedBy
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class LoginPresenter : HttpInjected {
    private val disposables = CompositeDisposable()

    fun clear() {
        disposables.clear()
    }

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