package ca.six.demo.cleanviper.test

import io.reactivex.FlowableTransformer
import io.reactivex.ObservableTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

object threadAndCleaner {
    
    @JvmStatic
    fun <T> obsv() = ObservableTransformer<T, T> { upstream ->
        upstream.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { RxEspressoIdlingCounter.increase() }
            .doFinally { RxEspressoIdlingCounter.decrease() }
    }

    @JvmStatic
    fun <T> flow() = FlowableTransformer<T, T> { upstream ->
        upstream.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { RxEspressoIdlingCounter.increase() }
            .doFinally { RxEspressoIdlingCounter.decrease() }
    }

}