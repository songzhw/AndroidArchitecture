package ca.six.demo.biz.home

import android.os.Bundle
import ca.six.demo.core.BaseActivity
import ca.six.demo.core.BaseApp
import ca.six.demo.core.di.DaggerHttpComponent
import ca.six.demo.core.di.HttpModule

class HomeActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val appComponent = (application as BaseApp).appComponent
        DaggerHttpComponent.builder()
                .appComponent(appComponent)
                .httpModule(HttpModule("https://api.github.com"))
                .build()
                .inject(this)

        println("szw HomePage : $retrofit")

    }

}