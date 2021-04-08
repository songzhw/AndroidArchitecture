package ca.six.demo.lifecycle

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import ca.six.demo.R
import ca.six.demo.util.nav
import kotlinx.android.synthetic.main.activity_tv_btn.*

class DisposeDemo1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tv_btn)
        tv_simple.text = "page1"
    }

    fun onClickSimpleButton(v: View) {
        nav(DisposeDemo2::class.java)
    }

    fun onClickSimpleButton2(v: View) {
    }

    fun onClickSimpleButton3(v: View) {
        nav(DisposeDemo3::class.java)
    }

    fun onClickSimpleButton4(v: View) {
    }
}