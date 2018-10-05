package six.ca.dagger101.fifteen_qualifier

import android.app.Activity
import android.os.Bundle
import javax.inject.Inject

class FifteenActivity : Activity() {
    @Inject @BeijingOpera lateinit var operaSingers : Set<String>
//    @Inject lateinit var popSingers: Set<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        DaggerSingerComponent.create()
                .inject(this)

        operaSingers.forEach { println("szw opera: $it") }
//        popSingers.forEach { println("szw pop: $it") }
    }

}