package ca.six.demo.devonly

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.OnLifecycleEvent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import ca.six.demo.util.disposedBy
import java.util.concurrent.TimeUnit

object DummyNetwork {
    fun query(): Observable<String> = Observable.just("Hello")

    fun queryWithBackpressure(): Flowable<Int> {
        return Flowable.timer(3, TimeUnit.SECONDS)
                .flatMap { Flowable.just(3000) }
    }

}

fun Disposable.disposedBy(lifecycle: Lifecycle, lifecycleEvent: Lifecycle.Event) {
    lifecycle.addObserver(object : LifecycleObserver {
        @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
        fun onAny(source: LifecycleOwner, event: Lifecycle.Event) {
            if (event == lifecycleEvent) {
                println("szw disposed when1: ${this@disposedBy.isDisposed}")
                println("szw disposed at : ${event.name}()")
                this@disposedBy.dispose()
                println("szw disposed when2: ${this@disposedBy.isDisposed}")
            }
        }
    })
}

class RxMultiDemo : AppCompatActivity() {
    val subscribeManager: CompositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        println("szw onCreate")

        DummyNetwork.query()
                .subscribe { println("szw query(1) : $it") }
                .disposedBy(subscribeManager)

        DummyNetwork.queryWithBackpressure()
                .subscribe { println("szw query(2) : $it") }
                .disposedBy(this.lifecycle, Lifecycle.Event.ON_STOP)
    }

    override fun onDestroy() {
        subscribeManager.clear()
        println("szw onDestroy : "+subscribeManager.size())
        super.onDestroy()
    }

    override fun onStart() {
        super.onStart()
        println("szw onStart")
    }

    override fun onStop() {
        super.onStop()
        println("szw onStop")
    }

    override fun onResume() {
        super.onResume()
        println("szw onResume")
    }

    override fun onPause() {
        super.onPause()
        println("szw onPause")
    }
}