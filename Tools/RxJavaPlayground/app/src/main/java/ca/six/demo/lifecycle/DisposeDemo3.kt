package ca.six.demo.lifecycle

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import ca.six.demo.R
import ca.six.demo.util.disposedBy
import io.reactivex.Observable
import kotlinx.android.synthetic.main.activity_tv_btn.*
import java.util.concurrent.TimeUnit

// This screen have no memory leak, as we already register its disposable to the Activity's lifecycle
class DisposeDemo3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tv_btn)
        tv_simple.text = "page3"
    }

    fun onClickSimpleButton(v: View) {
    }

    fun onClickSimpleButton2(v: View) {
    }

    fun onClickSimpleButton3(v: View) {
    }

    fun onClickSimpleButton4(v: View) {
        Observable.interval(3, TimeUnit.SECONDS)
                .subscribe { println("szw Activity333333 : $it") }
                .disposedBy(lifecycle)
    }
}