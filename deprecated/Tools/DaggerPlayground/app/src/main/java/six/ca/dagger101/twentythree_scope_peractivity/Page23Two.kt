package six.ca.dagger101.twentythree_scope_peractivity

import android.app.Activity
import android.os.Bundle
import javax.inject.Inject

class Page23Two : Activity() {
    @Inject lateinit var http: HttpEngine23

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val commonComponent = (application as Application23).commonComponent
        DaggerTwo23Component.builder()
                .common23Component(commonComponent) //关键就在这行, 除了@Scope, 还得用同一个Common23Component
                .build()
                .inject(this)

        println("szw PageTwo : $http")
    }
}