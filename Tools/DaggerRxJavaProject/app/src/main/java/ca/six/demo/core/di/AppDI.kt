package ca.six.demo.core.di

import android.app.Application
import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(val app : Application) {

    @Provides @Singleton
    fun app() : Application{
        return app
    }

}


@Component(modules = [AppModule::class])
interface AppComponent {
    fun app() : Application
}