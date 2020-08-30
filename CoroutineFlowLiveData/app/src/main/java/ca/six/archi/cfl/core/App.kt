package ca.six.archi.cfl.core

import android.app.Application
import retrofit2.Retrofit

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        app = this
    }

    companion object {
        var app: App? = null
    }
}