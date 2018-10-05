package six.ca.dagger101.seventeen_mapkey

import android.app.Activity
import android.os.Bundle
import javax.inject.Inject

class SeventeenDemo : Activity() {
    @Inject lateinit var map : Map<Sense, String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        map.forEach{ k, v ->
            println("szw 17 $k, $v")
        }

    }
}