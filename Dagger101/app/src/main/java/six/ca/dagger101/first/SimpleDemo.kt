package six.ca.dagger101.first

import android.app.Activity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

import javax.inject.Inject

import six.ca.dagger101.R


class SimpleDemo : Activity() {
    @Inject
    @JvmField  //这个要注意. 要说明是public才行, 所以这里加上了一个@JvmField
    var apple: Apple? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        DaggerSimpleComponent.builder()
                .build()
                .inject(this)

        tvMain.text = apple!!.toString()

    }
}