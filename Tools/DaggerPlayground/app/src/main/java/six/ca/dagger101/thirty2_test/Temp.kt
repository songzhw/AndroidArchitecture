package six.ca.dagger101.thirty2_test

open class One {
	open fun foo() {}
	open fun second() {}
}

class Two(val one: One) {
	fun bar() {
		one.foo()
	}
}