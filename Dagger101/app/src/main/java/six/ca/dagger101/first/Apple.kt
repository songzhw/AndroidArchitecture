package six.ca.dagger101.first

import javax.inject.Inject

class Apple @Inject constructor() {

    override fun toString(): String {
        return "Good Apple"
    }
}