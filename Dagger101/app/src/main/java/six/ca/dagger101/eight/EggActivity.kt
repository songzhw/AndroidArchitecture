package six.ca.dagger101.eight

import android.app.Activity
import android.os.Bundle
import six.ca.dagger101.eight.di.DaggerEggComponent
import six.ca.dagger101.eight.di.EggModule
import javax.inject.Inject

class EggActivity : Activity() {
    @Inject lateinit var presenter: IEggPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        DaggerEggComponent.builder()
                .eggModule(EggModule())
                .build()
                .inject(this)

        println("szw EggPresenter = ${presenter}")
    }

}