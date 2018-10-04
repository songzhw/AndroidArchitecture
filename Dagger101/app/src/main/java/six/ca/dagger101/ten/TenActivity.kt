package six.ca.dagger101.ten

import android.app.Activity
import android.os.Bundle
import six.ca.dagger101.nine.di.Cloth
import six.ca.dagger101.nine.di.DaggerCamComponent
import six.ca.dagger101.nine.di.DaggerPackComponent
import six.ca.dagger101.nine.di.Food
import six.ca.dagger101.ten.di.DaggerPackComponent2
import six.ca.dagger101.ten.di.PackModule2
import javax.inject.Inject

class TenActivity : Activity() {
    @Inject lateinit var cloth: Cloth
    @Inject lateinit var food: Food

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val packComponent2 = DaggerPackComponent2.builder()
                .packModule2(PackModule2())
                .build()
        val miComponent2 = packComponent2.miComponent()
        miComponent2.inject(this)


        println("szw cloth = $cloth")
        println("szw food = $food")
    }

}