package six.ca.dagger101.seventh

import android.app.Activity
import android.os.Bundle
import javax.inject.Inject

class SevenDemo2 : Activity() {
    @Inject lateinit var sun3: Sun

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        DaggerSunComponent.builder()
                .sunModule(SingleSunModule.module)
                .build()
                .inject(this)

        //=> six.ca.dagger101.seventh.Sun@de8e82e, six.ca.dagger101.seventh.Sun@de8e82e
        println("szw 72 $sun3")
    }
}