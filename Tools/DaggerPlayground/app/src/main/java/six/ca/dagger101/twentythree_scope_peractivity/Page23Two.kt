package six.ca.dagger101.twentythree_scope_peractivity

import android.app.Activity
import android.os.Bundle
import javax.inject.Inject

class Page23Two : Activity() {
    @Inject lateinit var http: HttpEngine23

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        DaggerTwo23Component.create()
                .inject(this)

        println("szw PageTwo : $http")
    }
}