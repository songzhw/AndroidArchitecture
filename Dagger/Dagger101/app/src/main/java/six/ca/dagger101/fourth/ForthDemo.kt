package six.ca.dagger101.fourth

import android.app.Activity
import android.os.Bundle
import six.ca.dagger101.fourth.dagger.CatModule
import six.ca.dagger101.fourth.dagger.DaggerCatComponent
import javax.inject.Inject

class ForthDemo : Activity() {
    @Inject lateinit var cat : Cat

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        DaggerCatComponent.builder()
                .catModule(CatModule())
                .build()
                .inject(this)

        println("szw cat = $cat, ${cat.service}")
    }

}