package ca.six.demo.cleanviper.ext

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import io.reactivex.disposables.CompositeDisposable

interface RxDisposableCleaner : LifecycleObserver {
    val _allSubscriptions: CompositeDisposable
        get() = CompositeDisposable()


    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy(){
        println("szw onDestroy()")
        _allSubscriptions.clear()
    }
}