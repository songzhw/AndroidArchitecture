package six.ca.dagger101.thirty2_test

import android.os.Build
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import six.ca.dagger101.BuildConfig
import six.ca.dagger101.thirty1_test.TheoryApp

@RunWith(RobolectricTestRunner::class)
@Config(constants = BuildConfig::class, sdk = [Build.VERSION_CODES.LOLLIPOP], application = TheoryApp::class)
class LoginActivityTest {
	@Mock lateinit var presenter : LoginPresenter

	@Before
	fun setup(){
		MockitoAnnotations.initMocks(this)
	}

	@Test
	fun clickOne(){
		val activity : LoginActivity= Robolectric.buildActivity(LoginActivity::class.java).create().get()
		activity.presenter = presenter

		activity.clickOne()

		verify(presenter).two()
	}
}