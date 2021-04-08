package ca.six.demo.cleanviper.ext

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

fun Disposable.clearedBy(queue: CompositeDisposable) {
    queue.add(this)
}