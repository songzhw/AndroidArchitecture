package ca.six.demo

import android.app.Activity
import android.os.Bundle
import android.os.NetworkOnMainThreadException
import android.view.View
import io.reactivex.Completable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_tv_btn.*
import java.net.URL

class CompletableAwaitDemo : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tv_btn)

        tv_simple.text = "Completable blockingAwait"

        val success = Completable.fromAction(this::bgwork)
                .onErrorResumeNext {
                    Completable.fromAction {
                        println("szw errors $it")
                    }
                }
                .subscribeOn(Schedulers.io())
                .blockingAwait()

        println("szw actv.onCreate() 222 : $success")
    }


    fun onClickSimpleButton(v: View) {
    }

    fun onClickSimpleButton2(v: View) {
    }

    fun onClickSimpleButton3(v: View) {
    }

    fun onClickSimpleButton4(v: View) {
        println("szw click btn four")
    }

    fun bgwork() {
        println("szw bgwork() start() : ${Thread.currentThread().name}")
        val resp = request(URL("https://api.github.com/"))
        println("szw bgwork() done : $resp")
    }

    fun request(url: URL): String {
        Thread.sleep(20000)
        throw NetworkOnMainThreadException()
    }


}

