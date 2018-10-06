package ca.six.demo.lifecycle

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import ca.six.demo.R
import io.reactivex.Observable
import kotlinx.android.synthetic.main.activity_tv_btn.*
import java.util.concurrent.TimeUnit

// Even you exit this screen, logs still be printed out in our Logcat
// This means we have leak this page!!!
class DisposeDemo2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tv_btn)
        tv_simple.text = "page2"
    }

    fun onClickSimpleButton(v: View) {
    }

    fun onClickSimpleButton2(v: View) {
    }

    fun onClickSimpleButton3(v: View) {
    }

    fun onClickSimpleButton4(v: View) {
        Observable.interval(3, TimeUnit.SECONDS)
                .subscribe { println("szw Activity222 : $it") }
    }
}