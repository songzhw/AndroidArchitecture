package ca.six.demo.biz.home

import android.os.Bundle
import ca.six.demo.core.BaseActivity
import ca.six.demo.core.BaseApp

class HomeActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val appComponent = (application as BaseApp).appComponent
        val retrofit = appComponent.httpComponent()
                .baseHttpUrl("https://api.github.com")
                .build()
                .retrofit()

        println("szw HomePage : $retrofit")

    }

}