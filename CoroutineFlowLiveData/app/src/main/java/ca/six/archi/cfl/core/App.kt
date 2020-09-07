package ca.six.archi.cfl.core

import android.app.Application

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        app = this
        injector = DepProvider()
    }

    companion object {
        lateinit var app: App
        lateinit var injector: DepProvider
    }
}