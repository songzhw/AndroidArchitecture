package ca.six.rxdemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import io.reactivex.Observable
import io.reactivex.disposables.Disposable
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity() {
  var disposable: Disposable by Delegates.notNull<Disposable>()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    runRxDemo()
  }

  private fun runRxDemo() {
    val random = Random().nextInt(100)
    val sdf = SimpleDateFormat("hh:mm:ss")
    val one = Observable.interval(3, TimeUnit.SECONDS)
      .map { num -> "one$num" }
    val two = Observable.interval(2, TimeUnit.SECONDS)
      .map { num -> "two$num" }
    disposable = Observable.merge(one, two)
      .subscribe { anyData -> println("szw receives $anyData  -  ${sdf.format(Date())}") }
  }

  override fun onDestroy() {
    super.onDestroy()
    disposable.dispose()
  }
}
