package six.ca.dagger101.thirty2_test

class One {
	fun foo() {}
	fun second() {}
}

class Two(val one: One) {
	fun bar() {
		one.foo()
	}
}