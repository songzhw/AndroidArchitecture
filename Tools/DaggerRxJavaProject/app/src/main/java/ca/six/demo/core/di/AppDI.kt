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

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun app() : Application
    fun httpComponentBuilder() : HttpComponent.Builder
}

/*
这种写法也行. 就是不再需要AppModule类了.

@Singleton
@Component
interface AppComponent {
    fun app(): Application

    @Component.Builder
    interface Builder {
        fun build(): AppComponent
        @BindsInstance
        fun application(app: Application): AppComponent.Builder
    }
}
*/