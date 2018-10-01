package six.ca.dagger101.third

import android.app.Application
import six.ca.dagger101.third.dagger.CriticalComponent
import six.ca.dagger101.third.dagger.CriticalModule
import six.ca.dagger101.third.dagger.DaggerCriticalComponent

class Application3 : Application() {
    companion object {
        lateinit var appComponent: CriticalComponent
    }

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerCriticalComponent.builder()
                .criticalModule(CriticalModule())
                .build()
    }

}