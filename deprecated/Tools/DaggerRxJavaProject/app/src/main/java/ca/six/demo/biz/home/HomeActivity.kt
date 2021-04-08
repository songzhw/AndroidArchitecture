package ca.six.demo.biz.home

import android.os.Bundle
import ca.six.demo.core.BaseActivity

class HomeActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        println("szw HomePage : $retrofit")

    }

}