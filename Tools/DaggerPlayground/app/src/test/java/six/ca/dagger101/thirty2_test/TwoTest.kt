package six.ca.dagger101.thirty2_test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

@RunWith(JUnit4::class)
class TwoTest {

	@Mock lateinit var one: One

	@Before
	fun setup() {
		MockitoAnnotations.initMocks(this)
	}

	@Test
	fun testBar() {
		val two = Two(one)

		two.bar()

		verify(one).second()
	}
}