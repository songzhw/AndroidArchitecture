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
        println("szw onNext original = $num, at $time")
      }
      .throttleWithTimeout(3000, TimeUnit.MILLISECONDS)
      .subscribe { v ->
        val time = SimpleDateFormat("hh:mm:ss.SSS").format(Date())
        println("         szw receives ${v}, at ${time}")
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
szw onNext original = 0, at 04:23:27.487
         szw receives 0, at 04:23:27.488
szw onNext original = 1, at 04:23:28.485
szw onNext original = 2, at 04:23:29.486
szw onNext original = 3, at 04:23:30.485
szw onNext original = 4, at 04:23:31.486
         szw receives 4, at 04:23:31.487
szw onNext original = 5, at 04:23:32.487
szw onNext original = 6, at 04:23:33.485
szw onNext original = 7, at 04:23:34.485
szw onNext original = 8, at 04:23:35.485
         szw receives 8, at 04:23:35.486
szw onNext original = 9, at 04:23:36.485
*/


/*
throttleLast

szw onNext original = 0, at 04:24:14.726
szw onNext original = 1, at 04:24:15.723
szw onNext original = 2, at 04:24:16.723
         szw receives 1, at 04:24:16.723
szw onNext original = 3, at 04:24:17.723
szw onNext original = 4, at 04:24:18.722
         szw receives 4, at 04:24:19.722
szw onNext original = 5, at 04:24:19.722
szw onNext original = 6, at 04:24:20.723
szw onNext original = 7, at 04:24:21.723
szw onNext original = 8, at 04:24:22.723
         szw receives 7, at 04:24:22.723
szw onNext original = 9, at 04:24:23.722
szw onNext original = 10, at 04:24:24.725
 */

/*
throttleLatest : 明显就是想修复throttleLast这个号称是last, 却不见得一定是last的问题(如上面的num为7,8时)
 szw onNext original = 0, at 04:24:58.660
          szw receives 0, at 04:24:58.661
 szw onNext original = 1, at 04:24:59.659
 szw onNext original = 2, at 04:25:00.659
 szw onNext original = 3, at 04:25:01.659
          szw receives 3, at 04:25:01.663
 szw onNext original = 4, at 04:25:02.659
 szw onNext original = 5, at 04:25:03.660
 szw onNext original = 6, at 04:25:04.660
          szw receives 6, at 04:25:04.665
 szw onNext original = 7, at 04:25:05.659
 szw onNext original = 8, at 04:25:06.660
 szw onNext original = 9, at 04:25:07.660
          szw receives 9, at 04:25:07.667
 szw onNext original = 10, at 04:25:08.661
 szw onNext original = 11, at 04:25:09.660
 szw onNext original = 12, at 04:25:10.659
          szw receives 12, at 04:25:10.670
 szw onNext original = 13, at 04:25:11.659
 szw onNext original = 14, at 04:25:12.659
 szw onNext original = 15, at 04:25:13.660
          szw receives 15, at 04:25:13.674
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
