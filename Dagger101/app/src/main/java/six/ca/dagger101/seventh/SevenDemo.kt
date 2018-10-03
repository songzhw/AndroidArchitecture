package six.ca.dagger101.seventh

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.MotionEvent
import javax.inject.Inject

class SevenDemo : Activity() {
    @Inject lateinit var sun1: Sun
    @Inject lateinit var sun2: Sun

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        DaggerSunComponent.builder()
                .sunModule(SingleSunModule.module)
                .build()
                .inject(this)

        //=> six.ca.dagger101.seventh.Sun@de8e82e, six.ca.dagger101.seventh.Sun@de8e82e
        println("szw 71 $sun1, $sun2")
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        if (event.action == MotionEvent.ACTION_UP) {
            startActivity(Intent(this, SevenDemo2::class.java))
        }
        return super.onTouchEvent(event)
    }
}