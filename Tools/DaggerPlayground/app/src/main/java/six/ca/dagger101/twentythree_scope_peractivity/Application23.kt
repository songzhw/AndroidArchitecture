package six.ca.dagger101.twentythree_scope_peractivity

import android.app.Application

class Application23 : Application() {
    lateinit var commonComponent : Common23Component

    override fun onCreate() {
        super.onCreate()

        commonComponent = DaggerCommon23Component.create()
    }

}