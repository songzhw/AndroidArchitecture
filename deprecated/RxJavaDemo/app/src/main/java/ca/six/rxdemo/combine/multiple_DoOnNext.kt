package ca.six.rxdemo.combine

import io.reactivex.Observable
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit

fun demo() {
  val sdf = SimpleDateFormat("hh:mm:ss")
  val one = Observable.interval(3, TimeUnit.SECONDS)
    .map { num -> "one$num" }
  val two = Observable.interval(2, TimeUnit.SECONDS)
    .map { num -> "two$num" }
  val disposable = Observable.merge(one, two)
    .doOnNext { str -> if (str.startsWith("one")) println("  szw doOnNext1($str)") }
    .doOnNext { str -> if (str.startsWith("two")) println("  szw doOnNext2($str)") }
    .subscribe { anyData -> println("szw receives $anyData  -  ${sdf.format(Date())}\n") }
}

/*
   szw doOnNext2(two0)
 szw receives two0  -  02:07:53

   szw doOnNext1(one0)
 szw receives one0  -  02:07:54

   szw doOnNext2(two1)
 szw receives two1  -  02:07:55

   szw doOnNext2(two2)
 szw receives two2  -  02:07:57

   szw doOnNext1(one1)
 szw receives one1  -  02:07:57
*/