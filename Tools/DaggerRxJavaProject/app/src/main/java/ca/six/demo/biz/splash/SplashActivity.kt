package ca.six.demo.biz.splash

import android.content.Intent
import android.os.Bundle
import android.view.MotionEvent
import ca.six.demo.R
import ca.six.demo.biz.home.HomeActivity
import ca.six.demo.core.BaseActivity
import ca.six.demo.core.BaseApp
import ca.six.demo.core.di.DaggerHttpComponent
import ca.six.demo.core.di.HttpModule


class SplashActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val appComponent = (application as BaseApp).appComponent
        DaggerHttpComponent.builder()
                .appComponent(appComponent)
                .httpModule(HttpModule("https://api.github.com"))
                .build()
                .inject(this)

        println("szw SplashPage : $retrofit")

    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        if (MotionEvent.ACTION_UP == event.action) {
            startActivity(Intent(this, HomeActivity::class.java))
        }
        return super.onTouchEvent(event)
    }

}

