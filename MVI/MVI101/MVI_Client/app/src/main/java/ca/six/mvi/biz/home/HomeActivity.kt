package ca.six.mvi.biz.home

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import ca.six.mvi.R
import ca.six.mvi.utils.http.HttpEngine

class HomeActivity : AppCompatActivity() {
    val presenter = HomePresenter()  //TODO has a chance to inject it ?!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        presenter.onCreate()
    }
}
