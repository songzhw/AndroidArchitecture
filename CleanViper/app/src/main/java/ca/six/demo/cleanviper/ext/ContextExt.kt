package ca.six.demo.cleanviper.ext

import android.app.Activity
import android.content.Context
import android.view.Gravity
import android.widget.FrameLayout
import android.widget.Toast
import com.github.ybq.android.spinkit.SpinKitView

fun Context.showToast(message: String, duration: Int = Toast.LENGTH_SHORT) =
    Toast.makeText(this, message, duration).show()

fun Activity.showProgress() {
    val spinView = SpinKitView(this)
    val lp = FrameLayout.LayoutParams(200, 200)
    lp.gravity = Gravity.CENTER

    val decorView = this.window.decorView as FrameLayout
    decorView.addView(spinView, lp)
}