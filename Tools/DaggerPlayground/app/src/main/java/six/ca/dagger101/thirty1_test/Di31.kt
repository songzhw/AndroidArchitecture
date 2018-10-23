package six.ca.dagger101.thirty1_test

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceManager
import android.support.v7.app.AppCompatActivity
import dagger.Component
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class UserApiService

class UserManager

class PasswordValidator

@Module
class TheoryModule(val ctx: Context) {
	@Provides
	fun okhttp(): OkHttpClient {
		return OkHttpClient().newBuilder()
				.connectTimeout(30, TimeUnit.SECONDS)
				.build()
	}

	@Provides
	fun retrofit(okhttp: OkHttpClient): Retrofit {
		return Retrofit.Builder()
				.client(okhttp)
				.baseUrl("https://api.github.com")
				.build()
	}

	@Provides
	fun sp(): SharedPreferences {
		return PreferenceManager.getDefaultSharedPreferences(ctx)
	}

}

@Component(modules = [TheoryModule::class])
interface TheoryComponent {
	fun okhttp(): OkHttpClient
	fun retorfit(): Retrofit
	fun sp(): SharedPreferences
}

class TheoryApp : Application() {
	override fun onCreate() {
		super.onCreate()

		component = DaggerTheoryComponent.builder()
				.theoryModule(TheoryModule(this))
				.build()
	}

	companion object {
		lateinit var component: TheoryComponent
	}
}

class TheoryActivity : AppCompatActivity() {
	// component中没有inject(actv), 所以不能用@Inject来获得值
	//	@Inject lateinit var sp : SharedPreferences
	//	@Inject lateinit var retrofit: Retrofit

	lateinit var sp: SharedPreferences
	lateinit var retrofit: Retrofit

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		sp = TheoryApp.component.sp()
		retrofit = TheoryApp.component.retorfit()
	}

	fun foo() {
		sp.edit().putInt("num_thrityone", 23).apply()
	}

}