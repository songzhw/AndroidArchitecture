package ca.six.demo.util

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

fun Disposable.disposedBy(manager: CompositeDisposable) {
    manager.add(this)
}
