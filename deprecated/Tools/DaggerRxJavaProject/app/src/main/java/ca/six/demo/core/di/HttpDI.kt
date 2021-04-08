package ca.six.demo.core.di

import android.app.Application
import ca.six.demo.core.BaseActivity
import dagger.*
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
@Subcomponent(modules = [HttpModule::class])
interface HttpComponent {
    fun retrofit() : Retrofit

    @Subcomponent.Builder
    interface Builder {
        fun build() : HttpComponent
        @BindsInstance fun baseHttpUrl(url : String) : Builder
    }
}