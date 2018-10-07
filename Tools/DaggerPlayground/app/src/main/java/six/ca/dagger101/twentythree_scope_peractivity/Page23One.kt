package six.ca.dagger101.twentythree_scope_peractivity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.MotionEvent
import javax.inject.Inject

class Page23One : Activity() {
    @Inject lateinit var http: HttpEngine23

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        DaggerOne23Component.create()
                .inject(this)

        println("szw PageOne : $http")
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        if (event.action == MotionEvent.ACTION_UP) {
            startActivity(Intent(this, Page23Two::class.java))
        }
        return super.onTouchEvent(event)
    }
}