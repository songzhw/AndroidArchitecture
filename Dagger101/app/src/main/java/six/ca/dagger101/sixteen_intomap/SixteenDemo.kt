package six.ca.dagger101.sixteen_intomap

import android.app.Activity
import android.os.Bundle
import javax.inject.Inject

class SixteenDemo : Activity() {
    @Inject lateinit var map : Map<Int, String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        DaggerSun16Component.create()
                .inject(this)

        map.forEach { key, value ->
            println("szw $key,  $value")
        } //=> szw 23,  Jordan  ;   szw 8,  kobe
    }
}