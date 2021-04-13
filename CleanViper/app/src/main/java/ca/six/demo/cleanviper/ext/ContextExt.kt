package ca.six.demo.cleanviper.ext

import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.view.Gravity
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.FrameLayout
import android.widget.Toast
import com.github.ybq.android.spinkit.SpinKitView
import com.github.ybq.android.spinkit.style.CubeGrid

fun Context.showToast(message: String, duration: Int = Toast.LENGTH_SHORT) =
    Toast.makeText(this, message, duration).show()

fun Activity.showProgress(): SpinKitView {
    val spinView = SpinKitView(this)
    spinView.setColor(Color.MAGENTA)
    spinView.setIndeterminateDrawable(CubeGrid())
    val lp = FrameLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT)
    lp.gravity = Gravity.CENTER

    val decorView = this.window.decorView as FrameLayout
    decorView.addView(spinView, lp)

    return spinView
}

fun Activity.hideProgress(spinView: SpinKitView) {
    val decorView = this.window.decorView as FrameLayout
    decorView.removeView(spinView)
}