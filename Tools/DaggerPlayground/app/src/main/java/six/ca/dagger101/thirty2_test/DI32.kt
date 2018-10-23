package six.ca.dagger101.thirty2_test

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides

@Module
class LoginModule {
	@Provides
	fun api(): UserApiService {
		val retrofit = HttpEngine.retrofit()
		val userApiService = retrofit.create(UserApiService::class.java)
		return userApiService
	}

	@Provides
	fun sp(ctx: Context): SharedPreferences {
		return PreferenceManager.getDefaultSharedPreferences(ctx)
	}

	@Provides
	fun mgr(sp: SharedPreferences, api: UserApiService): UserManager {
		return UserManager(sp, api)
	}

	@Provides
	fun validator(): PasswordValidator {
		return PasswordValidator()
	}

	@Provides
	fun presenter(mgr: UserManager, validator: PasswordValidator) : LoginPresenter {
		return LoginPresenter(mgr, validator)
	}
}

@Component(modules = [LoginModule::class])
interface LoginComponent {
	fun inject(activity: LoginActivity)
}