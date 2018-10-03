package six.ca.dagger101.fifth

import android.app.Activity
import android.os.Bundle
import six.ca.dagger101.fifth.dagger.DaggerDogComponent
import six.ca.dagger101.fifth.dagger.DogHouseNameModule
import six.ca.dagger101.fifth.dagger.DogModule
import javax.inject.Inject

class FifthDemo : Activity() {

    @Inject lateinit var dog: Dog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        DaggerDogComponent.builder()
                .dogHouseNameModule(DogHouseNameModule())
                .dogModule(DogModule())
                .build()
                .inject(this)

        println("szw dog = $dog")

    }
}