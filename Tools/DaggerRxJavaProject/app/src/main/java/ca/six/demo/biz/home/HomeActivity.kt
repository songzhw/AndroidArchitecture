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
        val retrofit = DaggerHttpComponent.builder()
                .appComponent(appComponent)
                .baseHttpUrl("https://api.github.com")
                .build()
                .retrofit()

        println("szw HomePage : $retrofit")

    }

}