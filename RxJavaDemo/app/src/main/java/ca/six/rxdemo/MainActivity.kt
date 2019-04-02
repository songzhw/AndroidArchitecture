package ca.six.rxdemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
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
    disposable = Observable.interval(1000, TimeUnit.MILLISECONDS)
      .doOnNext{num ->
        val time = SimpleDateFormat("hh:mm:ss.SSS").format(Date())
        println("szw map original = $num at $time")
      }
      .throttleFirst(3000, TimeUnit.MILLISECONDS)
      .subscribe { v ->
        val time = SimpleDateFormat("hh:mm:ss.SSS").format(Date())
        println("    szw receives ${v}, at ${time}")
      }
  }
/*
没有throttle时, interval()数据是从0开始的


throttleFirst:
throttleLast: 1, 4, 7, ... 即时间点到了之后, 接下一来的第一个事件
throttleLatest

 */

/*
throttleFirst:
szw map original = 0 at 04:20:59.377
    szw receives 0, at 04:20:59.378
szw map original = 1 at 04:21:00.373
szw map original = 2 at 04:21:01.375
szw map original = 3 at 04:21:02.375
szw map original = 4 at 04:21:03.373
    szw receives 4, at 04:21:03.373
szw map original = 5 at 04:21:04.375
szw map original = 6 at 04:21:05.374
szw map original = 7 at 04:21:06.374
szw map original = 8 at 04:21:07.373
    szw receives 8, at 04:21:07.375
szw map original = 9 at 04:21:08.373
szw map original = 10 at 04:21:09.374
szw map original = 11 at 04:21:10.374
szw map original = 12 at 04:21:11.377
    szw receives 12, at 04:21:11.381
 */


/*
throttleLast

 */


  fun merge() {
    val sdf = SimpleDateFormat("hh:mm:ss")
    val one = Observable.interval(3, TimeUnit.SECONDS)
      .map { num -> "one$num" }
    val two = Observable.interval(2, TimeUnit.SECONDS)
      .map { num -> "two$num" }
    disposable = Observable.merge(one, two)
      .doOnNext { str -> if (str.startsWith("one")) println("  szw doOnNext1($str)") }
      .doOnNext { str -> if (str.startsWith("two")) println("  szw doOnNext2($str)") }
      .subscribe { anyData -> println("szw receives $anyData  -  ${sdf.format(Date())}\n") }
  }

  override fun onDestroy() {
    super.onDestroy()
    disposable.dispose()
  }

  fun onClick(view: View) {
    disposable.dispose()
  }
}
