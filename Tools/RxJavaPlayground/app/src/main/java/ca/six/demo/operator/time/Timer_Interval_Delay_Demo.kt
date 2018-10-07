package ca.six.demo.operator.time

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import ca.six.demo.R
import ca.six.demo.util.disposedBy
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_tv_btn.*
import java.util.*
import java.util.concurrent.TimeUnit

class ThreeTimeOperatorDemo : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tv_btn)
    }

    fun onClickSimpleButton(v: View) {
        // 没有发生在主线程上, 因为我点击btn4, 立即tv就有反应! 因为默认是在Scheduler.computation()里执行的
        Observable.timer(10, TimeUnit.SECONDS, Schedulers.trampoline())
                .flatMap {
                    println("szw flatMap  $it")
                    Observable.just("timer()")
                }
                .subscribe { println("szw subscribe $it") }
                .disposedBy(lifecycle)
    }

    fun onClickSimpleButton2(v: View) {
        // 这会堵塞住主线程! 引起ANR
        Observable.timer(10, TimeUnit.SECONDS, Schedulers.trampoline())
                .flatMap {
                    println("szw flatMap  $it")
                    Observable.just("timer()")
                }
                .subscribe { println("szw subscribe $it") }
                .disposedBy(lifecycle)
    }

    fun onClickSimpleButton3(v: View) {
        // 用.delay(4, TimeUnit.SECONDS, Schedulers.trampoline()), 就会堵塞主线程
        // 用.delay(4, TimeUnit.SECONDS), 就不会堵塞主线程
        Observable.just("first data")
                .delay(4, TimeUnit.SECONDS)
                .subscribe {
                    println("szw subscribe $it : ${Thread.currentThread().name}")
                    //=>  subscribe first data : RxComputationThreadPool-1
                }
                .disposedBy(lifecycle)
// 4秒后才收到"subscribe first data"
    }

    fun onClickSimpleButton4(v: View) {
        val num = Random().nextInt()
        tv_simple.text = "text : $num"
        println("szw click button 04  : $num")

    }
}