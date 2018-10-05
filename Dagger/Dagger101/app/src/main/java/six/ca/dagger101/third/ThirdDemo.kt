package six.ca.dagger101.third

import android.app.Activity
import android.os.Bundle
import six.ca.dagger101.third.dagger.ICriticalReceiver
import javax.inject.Inject

class ThirdDemo : Activity(), ICriticalReceiver {
    @Inject lateinit var http : HttpClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Application3.appComponent.inject(this)

        println("szw httpClient = $http")
    }
}