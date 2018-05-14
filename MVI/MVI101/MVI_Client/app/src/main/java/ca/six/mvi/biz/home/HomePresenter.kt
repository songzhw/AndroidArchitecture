package ca.six.mvi.biz.home

import ca.six.mvi.utils.http.HttpEngine
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class HomePresenter {

    fun onCreate(){
        HttpEngine().get("http://192.168.2.26:8899/todos")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe{ resp ->
                    println("szw presenter : $resp")
                    println("szw p2 : ${resp.body()?.string()}")
                }
    }
}