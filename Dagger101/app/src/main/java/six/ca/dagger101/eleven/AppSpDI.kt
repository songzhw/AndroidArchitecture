package six.ca.dagger101.eleven

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides

@Module
class AppSpModule {
    @Provides
    fun getSp(app: Application): SharedPreferences {
        return app.getSharedPreferences("myapp", Context.MODE_PRIVATE)
    }
}

@Component(modules = [AppSpModule::class])
interface AppSpComonent {
    fun inject(receiver: Base11Activity)

    @Component.Builder
    interface Builder {
        fun build() : AppSpComonent
        @BindsInstance fun application(app: Application) : Builder
    }
}