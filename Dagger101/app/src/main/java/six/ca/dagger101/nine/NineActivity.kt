package six.ca.dagger101.nine

import android.app.Activity
import android.os.Bundle
import six.ca.dagger101.nine.di.Cloth
import six.ca.dagger101.nine.di.DaggerCamComponent
import six.ca.dagger101.nine.di.DaggerPackComponent
import javax.inject.Inject

class NineActivity : Activity() {
    @Inject lateinit var cloth: Cloth //由CamCompnent的dependency, 即PackComponent, 提供

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val packComponent = DaggerPackComponent.create()
        DaggerCamComponent.builder()
                .packComponent(packComponent)
                .build()
                .inject(this)

        println("szw closth = $cloth")
    }

}