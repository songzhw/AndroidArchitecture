package ca.six.demo.core.di

import android.app.Application
import ca.six.demo.core.BaseActivity
import dagger.Component
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class HttpModule(val baseUrl : String) {

    @Provides @Singleton
    fun retorfit(okhttp : OkHttpClient): Retrofit {
        return Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(okhttp)
                .build()
    }

    @Provides @Singleton
    fun okhttp(cache: Cache): OkHttpClient {
        return OkHttpClient.Builder()
                .cache(cache)
                .build()
    }

    @Provides @Singleton
    fun okHttpCache(app: Application) : Cache {
        val cacheSize = 12L * 1024 * 1024 //12MB
        return Cache(app.cacheDir, cacheSize)
    }

}

@Component(modules = [HttpModule::class], dependencies = [AppComponent::class])
interface HttpComponent {
    fun inject(receiver: BaseActivity)
}