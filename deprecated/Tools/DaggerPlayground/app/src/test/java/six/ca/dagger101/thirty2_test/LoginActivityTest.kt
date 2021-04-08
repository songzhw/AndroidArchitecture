package six.ca.dagger101.thirty2_test

import android.os.Build
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config
import six.ca.dagger101.BuildConfig
import six.ca.dagger101.thirty1_test.TheoryApp

/*
- testClickOne() 更容易, 我们可以直接用Mocked对象来替换
- testOnInit() 就麻烦了, 因为我们在onCreate()里已经调用了presenter.init(), 没有给我们注入的机会 (再注入也是在onCreate之后了)
 */
@RunWith(RobolectricTestRunner::class)
@Config(constants = BuildConfig::class, sdk = [Build.VERSION_CODES.LOLLIPOP], application = TheoryApp::class)
class LoginActivityTest {
	@Mock lateinit var mockedPresenter : LoginPresenter

	@Before
	fun setup(){
		MockitoAnnotations.initMocks(this)
	}

	@Test
	fun testOnInit(){
		println("szw test app = ${RuntimeEnvironment.application}")
	}

	@Test
	fun testClickOne(){
		val activity : LoginActivity= Robolectric.buildActivity(LoginActivity::class.java).create().get()
		activity.presenter = mockedPresenter

		activity.clickOne()

		verify(mockedPresenter).fetch()
	}
}