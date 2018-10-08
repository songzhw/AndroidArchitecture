package ca.six.demo.core

import android.app.Application
import ca.six.demo.core.di.AppComponent
import ca.six.demo.core.di.AppModule
import ca.six.demo.core.di.DaggerAppComponent

class BaseApp : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()
    }

}