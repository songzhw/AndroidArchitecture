package six.ca.dagger101.thirty2_test.mockito

import six.ca.dagger101.Mockable

open class One {
	open fun foo() {}
	open fun second() {}
}

class Two(val one: One) {
	fun bar() {
		one.foo()
	}
}

// = = = = = = = = = = = = = = = =
@Mockable
class One2{
	fun foo() {}
	fun second() {}
}

class Two2(val one: One2) {
	fun bar() {
		one.foo()
	}
}