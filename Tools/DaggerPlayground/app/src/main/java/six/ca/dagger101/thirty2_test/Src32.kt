package six.ca.dagger101.thirty2_test

import android.content.SharedPreferences
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.Retrofit
import okhttp3.OkHttpClient
import six.ca.dagger101.Mockable
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class Repo {
	var id: Int = 0 //lateinit var不能用于基本类型
	var isForked = false
	lateinit var name: String
}

interface UserApiService {
	@GET("users/{user}/repos")
	fun listRepos(@Path("user") user: String): Call<List<Repo>>
}

class UserManager(val sp: SharedPreferences, val api: UserApiService)

class PasswordValidator

@Mockable
class LoginPresenter(val mgr: UserManager, val validator: PasswordValidator) {
	fun init() {}
	fun fetch() {}
}

// kotlin中一个全局object就解决的问题, 真没必要用Dagger.
object HttpEngine {
	fun retrofit(): Retrofit {
		val okhttpClient = OkHttpClient.Builder()
				.connectTimeout(30, TimeUnit.SECONDS)
				.build()
		val retrofit = Retrofit.Builder()
				.client(okhttpClient)
				.baseUrl("https://api.github.com")
				.build()
		return retrofit
	}
}

class LoginActivity : AppCompatActivity() {
	@Inject
	lateinit var presenter: LoginPresenter

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		DaggerLoginComponent.builder()
				.app(this.application)
				.build()
				.inject(this)

	}

	fun clickOne() {
		println("szw click one()")
		presenter.init()
	}
}

/*
Errors I got before:
Mockito cannot mock/spy following:
  - final classes  (In this case, this requires us to add an "open" to LoginPrsenter)
  - anonymous classes
  - primitive types
 */