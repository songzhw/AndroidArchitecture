package ca.six.rxdemo.combine

import io.reactivex.Observable
import io.reactivex.functions.BiFunction
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit

fun rxDemo() {
  val one = Observable.interval(3, TimeUnit.SECONDS)
  val two = Observable.interval(2, TimeUnit.SECONDS)

  val disposable = two
    .withLatestFrom(one, BiFunction<Long, Long, String> { num1, num2 ->
      val sdf = SimpleDateFormat("hh:mm:ss")
      "$num1, $num2 - ${sdf.format(Date())}"
    })
    .subscribe { str -> println("szw output = $str") }
}
/*
szw output = 1, 0 - 01:27:35
szw output = 2, 0 - 01:27:37
szw output = 3, 1 - 01:27:39
szw output = 4, 2 - 01:27:41
szw output = 5, 2 - 01:27:43
szw output = 6, 3 - 01:27:45
szw output = 7, 4 - 01:27:47
szw output = 8, 4 - 01:27:49
szw output = 9, 5 - 01:27:51
... ...
...
 */