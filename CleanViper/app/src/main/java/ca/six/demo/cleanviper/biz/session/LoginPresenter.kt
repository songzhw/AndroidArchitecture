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
        http.loginAndFail()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { resp -> println("szw resp = ${resp.code()}, ${resp.body().toString()}") },//=> 406, null
                { error -> println("szw error = $error") }
            )
            .clearedBy(disposables)
    }
}