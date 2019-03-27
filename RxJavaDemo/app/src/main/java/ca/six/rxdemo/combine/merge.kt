package ca.six.rxdemo.combine

import io.reactivex.Observable
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit

fun merge(){
  val sdf = SimpleDateFormat("hh:mm:ss")
  val one = Observable.interval(3, TimeUnit.SECONDS)
    .map { num -> "one$num" }
  val two = Observable.interval(2, TimeUnit.SECONDS)
    .map { num -> "two$num" }
  Observable.merge(one, two)
    .subscribe { anyData -> println("szw receives $anyData  -  ${sdf.format(Date())}\n") }
}

/*
szw receives two0  -  01:58:03
szw receives one0  -  01:58:04
szw receives two1  -  01:58:05
szw receives one1  -  01:58:07
szw receives two2  -  01:58:07
...
 */