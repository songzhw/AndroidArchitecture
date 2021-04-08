package six.ca.dagger101.thirty2_test.mockito

import org.junit.Test

import org.junit.Assert.*
import org.mockito.Mockito.*

class Two2Test {

	@Test
	fun bar() {
		val one = mock(One2::class.java)
		val two = Two2(one)

		two.bar()

		verify(one).foo()
//		verify(one).second() // this will failed, as we expected, after we add @Mockable to One2 class
	}
}