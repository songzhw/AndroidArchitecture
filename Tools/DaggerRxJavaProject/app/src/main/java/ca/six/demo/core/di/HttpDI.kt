package ca.six.demo.core.di

import android.app.Application
import ca.six.demo.core.BaseActivity
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Singleton


@Module
class HttpModule() {

    @Provides @PerActivity
    fun retorfit(baseUrl : String, okhttp : OkHttpClient): Retrofit {
        return Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(okhttp)
                .build()
    }

    @Provides @PerActivity
    fun okhttp(cache: Cache): OkHttpClient {
        return OkHttpClient.Builder()
                .cache(cache)
                .build()
    }

    @Provides @PerActivity
    fun okHttpCache(app: Application) : Cache {
        val cacheSize = 12L * 1024 * 1024 //12MB
        return Cache(app.cacheDir, cacheSize)
    }

}

@PerActivity
@Component(modules = [HttpModule::class], dependencies = [AppComponent::class])
interface HttpComponent {
    fun retrofit() : Retrofit

    @Component.Builder
    interface Builder {
        fun build() : HttpComponent
        fun appComponent(appComponent: AppComponent) : Builder
        @BindsInstance fun baseHttpUrl(url : String) : Builder
    }
}