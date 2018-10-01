package six.ca.dagger101.fifth

import android.app.Activity
import android.os.Bundle
import javax.inject.Inject

class FifthDemo : Activity() {

    @Inject lateinit var dog: Dog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        println("szw dog = $dog")

    }
}