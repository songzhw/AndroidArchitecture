package ca.six.demo.core

import android.app.Application
import ca.six.demo.core.di.AppComponent
import ca.six.demo.core.di.AppModule
import ca.six.demo.core.di.DaggerAppComponent
import ca.six.demo.core.di.HttpComponent

class BaseApp : Application() {

    lateinit var appComponent: AppComponent
    lateinit var httpComponent : HttpComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()

        httpComponent = appComponent.httpComponentBuilder()
                .baseHttpUrl("https://api.github.com")
                .build()
    }

}

/*
        appComponent = DaggerAppComponent.builder()
                .application(this)
                .build()
 */


