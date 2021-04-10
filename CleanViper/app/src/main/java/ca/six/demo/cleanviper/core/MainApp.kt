package ca.six.demo.cleanviper.core

import android.app.Application
import ca.six.demo.cleanviper.router.core.Router

class MainApp : Application() {
    override fun onCreate() {
        super.onCreate()
        Router.init()
    }
}