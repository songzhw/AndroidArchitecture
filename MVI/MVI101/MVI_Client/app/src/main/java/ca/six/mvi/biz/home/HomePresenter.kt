package ca.six.mvi.biz.home

import ca.six.mvi.utils.http.HttpEngine
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class HomePresenter {

    fun onCreate(){
        HttpEngine().get("http://localhost:8899/todos")
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe{ resp ->
                    println("presenter : $resp")
                }
    }
}