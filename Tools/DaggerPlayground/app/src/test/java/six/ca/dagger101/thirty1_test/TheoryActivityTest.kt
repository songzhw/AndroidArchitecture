package six.ca.dagger101.thirty1_test

import android.os.Build
import android.preference.PreferenceManager
import junit.framework.Assert.assertEquals
import org.junit.Test

import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config
import six.ca.dagger101.BuildConfig

@RunWith(RobolectricTestRunner::class)
@Config(constants = BuildConfig::class, sdk = [Build.VERSION_CODES.LOLLIPOP], application = TheoryApp::class)
class TheoryActivityTest {

	@Test
	fun foo() {
		val activity : TheoryActivity= Robolectric.buildActivity(TheoryActivity::class.java).create().get()
		activity.foo()

		val app = RuntimeEnvironment.application
		val sp = PreferenceManager.getDefaultSharedPreferences(app)
		val num = sp.getInt("num_thrityone", 0)

		assertEquals(23, num)
	}
}