package ca.six.mvi.biz.home

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class HomePresenter {
    val model = HomeModel()

    fun onCreate() {
        model.getTodoList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { data ->
                    println("szw presenter ${data.toString()}")
                }

    }
}