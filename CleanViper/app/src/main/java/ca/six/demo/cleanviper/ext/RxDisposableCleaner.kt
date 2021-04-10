package ca.six.demo.cleanviper.ext

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import io.reactivex.disposables.CompositeDisposable

class RxDisposableCleaner : LifecycleObserver {
    val disposables: CompositeDisposable
        get() = CompositeDisposable()


    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy() {
        disposables.clear()
        println("szw onDestory() compositeDisposable.clear()")
    }
}

interface RxCleanerInjected {
    val rxCleaner: RxDisposableCleaner
        get() = RxDisposableCleaner()

    val disposables: CompositeDisposable
        get() = rxCleaner.disposables
}