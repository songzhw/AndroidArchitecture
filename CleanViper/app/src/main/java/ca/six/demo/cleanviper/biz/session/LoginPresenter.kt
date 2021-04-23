package ca.six.demo.cleanviper.biz.session

import autodispose2.AutoDispose.autoDisposable
import ca.six.demo.cleanviper.core.di.HttpInjected
import ca.six.demo.cleanviper.core.session.UserSession
import ca.six.demo.cleanviper.ext.clearedBy
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class LoginPresenter(val view: ILoginView) : HttpInjected {

    fun login(name: String, password: String) {
        //TODO password -> sha128

        // 这里是个模拟后台的过程, 根据name来决定login是否成功
        // name为空就直接失败; name为szw就直接是vip; 其它name全是普通用户登录成功
        val httpRequest = if (name == "szw") http.loginVIPUser()
        else http.LoginUser()


        if (name == "") {
            http.loginAndFail()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .to()
                .subscribe { resp -> view.toast("szw Something is wrong (#${resp.code()})") }
        } else {
            httpRequest
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext { resp -> UserSession.convertFrom(resp) }
                .subscribe { view.continueNav() }
        }

    }
}

/*
1. 这里我并没有采用Interactor. 因为感觉这里逻辑较简单, 用了interactor, 那presenter基本就是个空壳子, 来回传递而已.
    => 所以我个人觉得, 设计并不是一成不变的, 得因地制宜

 */