package six.ca.dagger101.twelve

import android.app.Activity
import android.os.Bundle
import dagger.Lazy
import javax.inject.Inject

class TangDemo : Activity() {
    @Inject lateinit var tang : Lazy<Tang>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        DaggerTangComponent.create()
                .inject(this)

        println("szw : tang = ${tang.get()}")  // get()是返回的Tang!类型
    }

}