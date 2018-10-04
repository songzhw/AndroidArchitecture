package six.ca.dagger101.thirteen_intoset

import android.app.Activity
import android.os.Bundle
import javax.inject.Inject

class ThirteenDemo : Activity() {
    @Inject lateinit var weather: Set<String>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        DaggerWeatherComponent.create()
                .inject(this)

        weather.forEach { println("szw $it") }
    }
}