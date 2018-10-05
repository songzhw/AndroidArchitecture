package six.ca.dagger101.forteen_noinject

import android.app.Activity
import android.os.Bundle

class ForteenDemo : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val component = DaggerForteenComponent.create()
        val set = component.numbers()
        set.forEach { println("szw 14 : $it") } //=> one

        val name = component.name()
        println("szw 14 name = $name")      //=> szw
    }

}